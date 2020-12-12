<?php
    //Se incia la sesión
    session_start();
    
    //Si no se ha iniciado sesión se le redirige a la página principal
	if(!isset($_SESSION["username"])){
		header("location: ../index.php");
		die();
	}
    // Si ha iniciado sesión se comprueba que no haya estado inactivo mucho tiempo
	else if (time() > $_SESSION['tiempoExpiracion'] + 60){ 
        session_destroy();
        session_start();
		$_SESSION["loginError"] = "Sesión cerrada por inactividad";
		header("location: ../index.php"); 
		die();
	}
	$_SESSION['tiempoExpiracion']=time();

    // Comprobamos que haya información en todos los campos
    if ( !isset($_POST['marca'],$_POST['fecha'],$_POST['dni'],$_POST['importe'])) {
        $_SESSION['addRepError'] = "Se han de rellenar todos los campos";
        header("location: ../view/reparaciones/addReparacionPage.php");
        die();
    }   

    //Se comprueban los datos 
    $marca = $_POST['marca'];
    $fecha = $_POST['fecha'];
    $dni = $_POST['dni'];
    $importe = $_POST['importe'];

    // Se comprueba la fecha:

    $format = 'd-m-Y';
    $d = DateTime::createFromFormat($format, $fecha);
    if(!($d && $d->format($format) === $fecha)){
        $_SESSION['addRepError'] = "Introduzca una fecha en el formato correcto";
        header("location: ../view/reparaciones/addReparacionPage.php");
        die();
    }
    // Se le da formato SQL
    $newFecha = date('Y-m-d', strtotime($fecha)); 

    //Comprobamos que el dni sea válido
	$partes = explode('-', $dni);
	$numeros = $partes[0];
	$letra = strtoupper($partes[1]);
	$letrasDNI="TRWAGMYFPDXBNJZSQVHLCKE";
	if(!is_numeric($numeros) || substr($letrasDNI, $numeros%23, 1) != $letra || strlen($letra) != 1 || strlen ($numeros) != 8 ){
		$_SESSION['addRepError'] = "Introduzca un DNI válido";
		header("location: ../view/reparaciones/addReparacionPage.php");
		exit();
	}
	$dni=$numeros."-".$letra;


    // Se comprueba el importe:
    $regexFormatoPrecio = '/^(0|[1-9]\d*)(\.\d{2})?$/';
    if (preg_match($regexFormatoPrecio, $importe) == '0') {
        $_SESSION['addRepError'] = "Introduzca un valor de importe válido";
        header("location: ../view/reparaciones/addReparacionPage.php");
        die();
    }

    // Se añade la reparación:

    // BASE DE DATOS
	// Variables para la base de datos:
	$DATABASE_HOST = '172.17.0.2:3306';
	$DATABASE_USER = 'admin';
	$DATABASE_PASS = 'test';
	$DATABASE_NAME = 'database';

	// Se connecta con la base de datos.
	$dbconnection = mysqli_connect($DATABASE_HOST, $DATABASE_USER, $DATABASE_PASS, $DATABASE_NAME);
	// Se comprueba la conexión con la base de datos.
    if (!$dbconnection) {
        die("Connection failed: " . mysqli_connect_error());
    }


    // Se prepara todo para comprobar que el código Random no existe.
    $cod = '';
    $sqlQuery = "SELECT * FROM reparacion WHERE CODREP=?";
    $sqlSTMT = $dbconnection->prepare($sqlQuery);
    $sqlSTMT->bind_param("s", $cod);

    $sqlResults = FALSE;

    while (!$sqlResults){
        //Se crea un código random:
        $randomid = mt_rand(10000,90000);
        $fragFecha = explode('-', $fecha);
        $fragFecha = (int)($fragFecha[0]+$fragFecha[1]);
        $randomid = $randomid + $fragFecha;
        $cod = strval($randomid).strtoupper($marca[0]).substr(md5(microtime()),rand(0,26),1);

        $sqlResults=$sqlSTMT->execute();
    }
    $sqlSTMT->close();

    // Se crea la consulta SQL
    $sqlQuery = "INSERT INTO reparacion (CODREP, MARCA_RELOJ, FECHA_PETICION, IMPORTE, DNI_CLIENTE) 
    VALUES (?, ?, ?, ?, ?)";
    
    // Se ejecuta la consulta
    $sqlSTMT = $dbconnection->prepare($sqlQuery);    
    $sqlSTMT->bind_param("sssds", $cod,$marca,$newFecha,$importe,$dni);
    $sqlResults=$sqlSTMT->execute();
    $sqlSTMT->close();

    if ($sqlResults !== TRUE){
        $_SESSION['addRepError'] = "Error al añadir la reparación. Inténtelo de nuevo.";
        header("location: ../view/reparaciones/addReparacionPage.php");
        die();
    }

    /* Se cierra la conexión con la base de datos*/
    $dbconnection->close();
    ////////////////////////////////////////////////////////////////////////////////////////////////

    header("location: ../view/home.php");
?>
