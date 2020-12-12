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

    // Se crea una función de error
    function errorEditarReparacion(){
        echo '<form id="form" action="../view/reparaciones/editReparacionPage.php" method="post">';  
        echo '<input type="hidden" name="codReparacion" value="'.$_POST['codigo'].'">';
        echo '<input type="hidden" name="marcaReloj" value="'.$_POST['marca'].'">';
        echo '<input type="hidden" name="fechaPeticion" value="'.$_POST['fecha'].'">';
        echo '<input type="hidden" name="importe" value="'.$_POST['importe'].'">';
        echo '<input type="hidden" name="dniCliente" value="'.$_POST['dni'].'">';            
        echo'
        </form>
        <script type="text/javascript">
            document.getElementById("form").submit();
        </script>
        ';
    }

    // Comprobamos que haya información en todos los campos
    if ( !isset($_POST['codigo'],$_POST['marca'],$_POST['fecha'],$_POST['dni'],$_POST['importe'])) {
        $_SESSION['editRepError'] = "Se han de rellenar todos los campos";
        errorEditarReparacion();
        die();
    }   

    //Se comprueban los datos 
    $cod = $_POST['codigo'];
    $marca = $_POST['marca'];
    $fecha = $_POST['fecha'];
    $dni = $_POST['dni'];
    $importe = $_POST['importe'];

    // Se comprueba la fecha:
    $format = 'd-m-Y';
    $d = DateTime::createFromFormat($format, $fecha);
    if(!($d && $d->format($format) === $fecha)){
        $_SESSION['editRepError'] = "Introduzca una fecha en el formato correcto";
        errorEditarReparacion();
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
		$_SESSION['editRepError'] = "Introduzca un DNI válido";
        errorEditarReparacion();
        die();
	}
	$dni=$numeros."-".$letra;

    // Se comprueba el importe:
    $regexFormatoPrecio = '/^(0|[1-9]\d*)(\.\d{2})?$/';
    if (preg_match($regexFormatoPrecio, $importe) == '0') {
        $_SESSION['editRepError'] = "Introduzca un valor de importe válido";
        errorEditarReparacion();
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
	//Se comprueba la conexión con la base de datos
    if (!$dbconnection) {
        die("Connection failed: " . mysqli_connect_error());
    }

    // Se crea la consulta SQL
    $sqlQuery = "UPDATE reparacion 
                SET MARCA_RELOJ = ?, FECHA_PETICION = ?, IMPORTE = ?, DNI_CLIENTE = ? 
                WHERE CODREP = ?";

// Se ejecuta la consulta
    $sqlSTMT = $dbconnection->prepare($sqlQuery);
    $sqlSTMT->bind_param("ssdss", $marca,$newFecha,$importe,$dni,$cod);
    $sqlResults=$sqlSTMT->execute();
    $sqlSTMT->close();

    if ($sqlResults !== TRUE){
        /* Se cierra la conexión con la base de datos*/
        $dbconnection->close();

        
        $_SESSION['editRepError'] = "Error al editar la reparación. Inténtelo de nuevo.";
        errorEditarReparacion();
        die();
    }

    /* Se cierra la conexión con la base de datos*/
    $dbconnection->close();

    header("location: ../view/home.php");
?>
