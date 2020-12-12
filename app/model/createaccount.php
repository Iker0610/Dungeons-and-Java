<?php
	//Se incia la sesión
	session_start();

	// Se comprueban los datos introducidos y su formato:
	// Comprobamos que haya información en todos los campos
	if ( !isset($_POST['dni'],$_POST['username'],$_POST['password'],$_POST['nombre'],$_POST['apellido'],$_POST['telefono'],$_POST['fechaN'],$_POST['email'],$_POST['iban'])) {
		// No se pudieron obtener todos los datos.
		exit('Rellena todos los campos');
	}

	$dni = $_POST['dni'];
	$user = $_POST['username'];
	$pswd = $_POST['password'];
	$name = $_POST['nombre'];
	$sname = $_POST['apellido'];
	$tlf = $_POST['telefono'];
	$date = $_POST['fechaN'];
	$mail = $_POST['email'];
	$iban = $_POST['iban'];

	//Comprobamos que el dni sea válido
	$partes = explode('-', $dni);
	$numeros = $partes[0];
	$letra = strtoupper($partes[1]);
	$letrasDNI="TRWAGMYFPDXBNJZSQVHLCKE";
	if(!is_numeric($numeros) || substr($letrasDNI, $numeros%23, 1) != $letra || strlen($letra) != 1 || strlen ($numeros) != 8 ){
		$_SESSION['createAccountError'] = "Introduzca un DNI válido";
		header("location: ../view/singupPage.php");
		exit();
	}
	$dni=$numeros."-".$letra;

	//Comprobar formato de email
	if (!filter_var($mail, FILTER_VALIDATE_EMAIL)){
		$_SESSION['createAccountError'] = "Email incorrecto";
		header("location: ../view/singupPage.php");
		exit();
	}

	//Comprobamos que el teléfono sea una cadena de 9 números
	if(!is_numeric($tlf) || strlen ($tlf)!=9){
		$_SESSION['createAccountError'] = "Teléfono incorrecto";
		header("location: ../view/singupPage.php");
		exit();
	}

	//Comprobar que los nombres y apellidos son texto
	$permitidos = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZñÑáéíóúÁÉÍÓÚ";
	for ($i=0; $i<strlen($name); $i++){
		if (strpos($permitidos, substr($name,$i,1))===false){
			$_SESSION['createAccountError'] = "Formato de nombre incorrecto";
			header("location: ../view/singupPage.php");
			exit();		
		}
	}

	for ($i=0; $i<strlen($sname); $i++){
		if (strpos($permitidos, substr($sname,$i,1))===false){
			$_SESSION['createAccountError'] = "Formato de apellido incorrecto";
			header("location: ../view/singupPage.php");
			exit();
		}
	}


	//Comprobamos que la fecha este en el formato correcto
	$format = 'd-m-Y';
	$d = DateTime::createFromFormat($format, $date);
	if(!($d && $d->format($format) === $date)){
		$_SESSION['createAccountError'] = "Formato de fecha incorrecto";
		header("location: ../view/singupPage.php");
		exit();
	}

	//Comprobamos que el nombre de usuario solo sea un valor alfanumérico:
	if (!ctype_alnum($user)){
		$_SESSION['createAccountError'] = "Solo se permiten valores alfanuméricos en el Nombre de Usuario.";
		header("location: ../view/singupPage.php");
		exit();
	}

	//Comprobamos que la password tenga mayúsculas, minúsculas, números y símbolos raros. Además ha de ser de 8 carácteres.
	$tieneMayus = preg_match('@[A-Z]@', $pswd);
	$tieneMinus = preg_match('@[a-z]@', $pswd);
	$tieneNum    = preg_match('@[0-9]@', $pswd);
	$tieneSpecialChars = preg_match('@[\@\$\¿\¡\!\%\*\?\&\#\_]@', $pswd);
	if (strlen($pswd)<8 || !$tieneMayus || !$tieneMinus || !$tieneNum || !$tieneSpecialChars){
		$_SESSION['createAccountError'] = "La contraseña tiene que contener mayúsculas, minúsculas, números, símbolos extraños y ser de 8 carácteres mínimo.";
		header("location: ../view/singupPage.php");
		exit();
	}
	else{
		// Se hashea
		$pswd = password_hash($pswd, PASSWORD_BCRYPT);
	}

	//Comprobamos que el IBAN sea correcto

	/*
	Código obtenido de StackOverflow
	Pregunta: https://stackoverflow.com/questions/20983339/validate-iban-php
	Autor: https://stackoverflow.com/users/9926383/kalehmann
	*/

	$iban = strtolower(str_replace(' ','',$iban));
    $Countries = array('al'=>28,'ad'=>24,'at'=>20,'az'=>28,'bh'=>22,'be'=>16,'ba'=>20,'br'=>29,'bg'=>22,'cr'=>21,'hr'=>21,'cy'=>28,'cz'=>24,'dk'=>18,'do'=>28,'ee'=>20,'fo'=>18,'fi'=>18,'fr'=>27,'ge'=>22,'de'=>22,'gi'=>23,'gr'=>27,'gl'=>18,'gt'=>28,'hu'=>28,'is'=>26,'ie'=>22,'il'=>23,'it'=>27,'jo'=>30,'kz'=>20,'kw'=>30,'lv'=>21,'lb'=>28,'li'=>21,'lt'=>20,'lu'=>20,'mk'=>19,'mt'=>31,'mr'=>27,'mu'=>30,'mc'=>27,'md'=>24,'me'=>22,'nl'=>18,'no'=>15,'pk'=>24,'ps'=>29,'pl'=>28,'pt'=>25,'qa'=>29,'ro'=>24,'sm'=>27,'sa'=>24,'rs'=>22,'sk'=>24,'si'=>19,'es'=>24,'se'=>24,'ch'=>21,'tn'=>24,'tr'=>26,'ae'=>23,'gb'=>22,'vg'=>24);
    $Chars = array('a'=>10,'b'=>11,'c'=>12,'d'=>13,'e'=>14,'f'=>15,'g'=>16,'h'=>17,'i'=>18,'j'=>19,'k'=>20,'l'=>21,'m'=>22,'n'=>23,'o'=>24,'p'=>25,'q'=>26,'r'=>27,'s'=>28,'t'=>29,'u'=>30,'v'=>31,'w'=>32,'x'=>33,'y'=>34,'z'=>35);

    if(strlen($iban) == $Countries[substr($iban,0,2)]){

        $MovedChar = substr($iban, 4).substr($iban,0,4);
        $MovedCharArray = str_split($MovedChar);
        $NewString = "";

        foreach($MovedCharArray AS $key => $value){
            if(!is_numeric($MovedCharArray[$key])){
                $MovedCharArray[$key] = $Chars[$MovedCharArray[$key]];
            }
            $NewString .= $MovedCharArray[$key];
        }

        if(bcmod($NewString, '97') != 1)
        {
            $_SESSION['editAccountError'] = "El IBAN es incorrecto.";
			header("location: ../view/cuenta/editAccountPage.php");
			exit();
        }
    }
    else{
		$_SESSION['editAccountError'] = "El IBAN es incorrecto.";
		header("location: ../view/cuenta/editAccountPage.php");
		exit();
	}


	// BASE DE DATOS
	// Variables para la base de datos:
	$DATABASE_HOST = '172.17.0.2:3306';
	$DATABASE_USER = 'admin';
	$DATABASE_PASS = 'test';
	$DATABASE_NAME = 'database';

	// Nos conectamos a la dase de datos
	$con = mysqli_connect($DATABASE_HOST, $DATABASE_USER, $DATABASE_PASS, $DATABASE_NAME) or die ("No se puede conectar 1");
	//mysqli_connect_error());
	$db = mysqli_select_db( $con, $DATABASE_NAME ) or die ( "No se puede conectar 2" );


	//Comprobamos que no haya DNI repetidos
	$cons = mysqli_prepare($con, "SELECT * FROM usuario WHERE dni=?");
	mysqli_stmt_bind_param($cons, "s", $dni);
	mysqli_stmt_execute($cons);

	if(mysqli_stmt_fetch($cons)){
		$_SESSION['createAccountError'] = "Ese DNI ya está en uso";
		header("location: ../view/singupPage.php");
		exit();
	}

	//Comprobamos que el nombre de usuario sea único
	$cons1 = mysqli_prepare($con, "SELECT * FROM usuario WHERE nombre_usuario=?");
	mysqli_stmt_bind_param($cons1, "s", $user);
	mysqli_stmt_execute($cons1);

	if(mysqli_stmt_fetch($cons1)){
		$_SESSION['createAccountError'] = "El nombre de usuario ya está en uso";
		header("location: ../view/singupPage.php");
		exit();
	}

	//Creamos la nueva cuenta
	$newDate = date('Y-m-d', strtotime($date)); //Pasamos la fecha al formato que acepta MySQL
	$sqlQuery = "INSERT INTO usuario (DNI, NOMBRE_USUARIO, CONTRASENA, NOMBRE, APELLIDO, TELEFONO, FECHA_NACIMIENTO, EMAIL) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	$sqlSTMT = $con->prepare($sqlQuery);
    $sqlSTMT->bind_param("sssssiss", $dni, $user, $pswd, $name, $sname, $tlf, $newDate, $mail);
	$sqlResults=$sqlSTMT->execute();
	$sqlSTMT->close();

	if ($sqlResults !== TRUE){
        $_SESSION['createAccountError'] = "Ha habido un error. Vuelvelo a intentar.";
		header("location: ../view/singupPage.php");
		exit();
	}

	mysqli_close($con);

	// Se logea al usuario:
	session_destroy();
    session_start();
	$_SESSION['username'] = $user;
	$_SESSION['nombre'] = $name;
	$_SESSION['apellido'] = $sname;
	$_SESSION['telefono'] = $tlf;
	$_SESSION['nacimiento'] = $date;
	$_SESSION['email'] = $mail;
	$_SESSION['dni'] = $dni;
	$_SESSION['iban'] = $IBAN;
	$_SESSION['tiempoExpiracion']= time();

	// Creamos el log

	//Entrada del log
	$log  = "IP:\t\t\t".$_SERVER['REMOTE_ADDR'].PHP_EOL.
	"User:\t\t".$_POST['username'].PHP_EOL.
	"Resultado:\tSuccess".PHP_EOL.
	"Fecha:\t\t".date("d/m/Y - H:i:s").PHP_EOL.
	"-----------------------------------------------------------".PHP_EOL;

	//Guardamos la entrada en el fichero (si no existe se crea, si existe, se añade al final del fichero)
	file_put_contents("../logs/log_".date("dmY"), $log, FILE_APPEND);

	// Le redirigimos a la página principal.
	header("location: ../view/home.php");
	die();
?>
