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

	// Se comprueban los datos introducidos y su formato:
	// Comprobamos que haya información en todos los campos
	if ( !isset($_POST['NewUser'],$_POST['NewDNI'],$_POST['NewName'],$_POST['NewSName'],$_POST['NewTlf'],$_POST['NewMail'],$_POST['NewFNac'],$_POST['NewIBAN'])) {
		// No se pudieron obtener todos los datos.
		exit('Rellena todos los campos');
	}

	$dni = $_POST['NewDNI'];
	$user = $_POST['NewUser'];
	$name = $_POST['NewName'];
	$sname = $_POST['NewSName'];
	$tlf = $_POST['NewTlf'];
	$date = $_POST['NewFNac'];
	$mail = $_POST['NewMail'];
	$iban = $_POST['NewIBAN'];

	//Comprobamos que el dni sea válido
	$partes = explode('-', $dni);
	$numeros = $partes[0];
	$letra = strtoupper($partes[1]);
	$letrasDNI="TRWAGMYFPDXBNJZSQVHLCKE";
	if(!is_numeric($numeros) || substr($letrasDNI, $numeros%23, 1) != $letra || strlen($letra) != 1 || strlen ($numeros) != 8 ){
		$_SESSION['editAccountError'] = "Introduzca un DNI válido";
		header("location: ../view/cuenta/editAccountPage.php");
		exit();
	}
	$dni=$numeros."-".$letra;
	
	//Comprobar formato de email
	if (!filter_var($mail, FILTER_VALIDATE_EMAIL)){
		$_SESSION['editAccountError'] = "Email incorrecto";
		header("location: ../view/cuenta/editAccountPage.php");
		exit();
	}

	//Comprobamos que el teléfono sea una cadena de 9 números
	if(!is_numeric($tlf) || strlen ($tlf)!=9){
		$_SESSION['editAccountError'] = "Teléfono incorrecto";
		header("location: ../view/cuenta/editAccountPage.php");
		exit();
	}

	//Comprobar que los nombres y apellidos son texto
	$permitidos = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZñÑáéíóúÁÉÍÓÚ ";
	for ($i=0; $i<strlen($name); $i++){
		if (strpos($permitidos, substr($name,$i,1))===false){
			$_SESSION['editAccountError'] = "Formato de nombre incorrecto";
			header("location: ../view/cuenta/editAccountPage.php");
			exit();		
		}
	}

	for ($i=0; $i<strlen($sname); $i++){
		if (strpos($permitidos, substr($sname,$i,1))===false){
			$_SESSION['editAccountError'] = "Formato de apellido incorrecto";
			header("location: ../view/cuenta/editAccountPage.php");
			exit();
		}
	}


	//Comprobamos que la fecha este en el formato correcto
	$format = 'd-m-Y';
	$d = DateTime::createFromFormat($format, $date);
	if(!($d && $d->format($format) === $date)){
		$_SESSION['editAccountError'] = "Formato de fecha incorrecto";
		header("location: ../view/cuenta/editAccountPage.php");
		exit();
	}

	//Comprobamos que el nombre de usuario solo sea un valor alfanumérico:
	if (!ctype_alnum($user)){
		$_SESSION['editAccountError'] = "Solo se permiten valores alfanuméricos en el nombre de usuario.";
		header("location: ../view/cuenta/editAccountPage.php");
		exit();
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

	// Se connecta con la base de datos.
	$dbconnection = mysqli_connect($DATABASE_HOST, $DATABASE_USER, $DATABASE_PASS, $DATABASE_NAME);
	// Se comprueba la conexión con la base de datos.
    if (!$dbconnection) {
        die("Connection failed: " . mysqli_connect_error());
	}
	
	//Si el DNI es distinto -> Comprobamos que no haya DNI repetidos
	if ($_SESSION['dni'] !== $dni){
		$cons = mysqli_prepare($dbconnection, "SELECT * FROM usuario WHERE dni=?");
		mysqli_stmt_bind_param($cons, "s", $newdni);
		mysqli_stmt_execute($cons);

		if(mysqli_stmt_fetch($cons)){
			$_SESSION['editAccountError'] = "Ese DNI ya está en uso";
			header("location: ../view/cuenta/editAccountPage.php");
			exit();
		}
	}

	//Si el usuario es distinto -> Comprobamos que el nombre de usuario sea único
	if ($_SESSION['username'] !== $user){
		$cons1 = mysqli_prepare($dbconnection, "SELECT * FROM usuario WHERE nombre_usuario=?");
		mysqli_stmt_bind_param($cons1, "s", $user);
		mysqli_stmt_execute($cons1);

		if(mysqli_stmt_fetch($cons1)){
			$_SESSION['editAccountError'] = "El nombre de usuario ya está en uso";
			header("location: ../view/cuenta/editAccountPage.php");
			exit();
		}
	}

	//Pasamos la fecha al formato que acepta MySQL
	$newDate = date('Y-m-d', strtotime($date)); 

	$sqlQuery = "UPDATE usuario 
				SET DNI = ?, NOMBRE_USUARIO = ?, NOMBRE = ?, APELLIDO = ?, TELEFONO = ?, FECHA_NACIMIENTO = ?, EMAIL = ?                   
				WHERE NOMBRE_USUARIO = ?";

	// Se ejecuta la consulta
	$sqlSTMT = $dbconnection->prepare($sqlQuery);
    $sqlSTMT->bind_param("ssssisss", $dni,$user,$name,$sname,$tlf,$newDate,$mail,$user);
	$sqlResults=$sqlSTMT->execute();
	$sqlSTMT->close();

	if ($sqlResults !== TRUE){
        $_SESSION['editAccountError'] = "Error al modificar los datos. Inténtelo de nuevo.";
        header("location: ../view/cuenta/editAccountPage.php");
        die();
	}
	else{
		$_SESSION['username'] = $user;
        $_SESSION['nombre'] = $name;
        $_SESSION['apellido'] = $sname;
        $_SESSION['telefono'] = $tlf;
        $_SESSION['nacimiento'] = $date;
        $_SESSION['email'] = $mail;
        $_SESSION['dni'] = $dni;        
	}

	// CAMBIO DE CONTRASEÑA
	if (!empty($_POST['OldPasswd']) && !empty($_POST['NewPasswd'])){

		//Se comprueba que ambas contraseñas cumplan las condiciones

		//Comprobamos que la password tenga mayúsculas, minúsculas, números y símbolos raros. Además ha de ser de 8 carácteres.
		$tieneMayus = preg_match('@[A-Z]@', $_POST['OldPasswd']);
		$tieneMinus = preg_match('@[a-z]@', $_POST['OldPasswd']);
		$tieneNum    = preg_match('@[0-9]@', $_POST['OldPasswd']);
		$tieneSpecialChars = preg_match('@[\@\$\¿\¡\!\%\*\?\&\#\_]@', $_POST['OldPasswd']);
		if (strlen($_POST['OldPasswd'])<8 || !$tieneMayus || !$tieneMinus || !$tieneNum || !$tieneSpecialChars){
			$_SESSION['editAccountError'] = "La contraseña tiene que contener mayúsculas, minúsculas, números, símbolos extraños y ser de 8 carácteres mínimo.";
			header("location: ../view/singupPage.php");
			exit();
		}

		//Comprobamos que la password tenga mayúsculas, minúsculas, números y símbolos raros. Además ha de ser de 8 carácteres.
		$tieneMayus = preg_match('@[A-Z]@', $_POST['NewPasswd']);
		$tieneMinus = preg_match('@[a-z]@', $_POST['NewPasswd']);
		$tieneNum    = preg_match('@[0-9]@', $_POST['NewPasswd']);
		$tieneSpecialChars = preg_match('@[\@\$\¿\¡\!\%\*\?\&\#\_]@', $_POST['NewPasswd']);
		if (strlen($_POST['NewPasswd'])<8 || !$tieneMayus || !$tieneMinus || !$tieneNum || !$tieneSpecialChars){
			$_SESSION['editAccountError'] = "La contraseña tiene que contener mayúsculas, minúsculas, números, símbolos extraños y ser de 8 carácteres mínimo.";
			header("location: ../view/singupPage.php");
			exit();
		}


		// Se crea la consulta SQL
		$sqlQuery = "SELECT CONTRASENA FROM usuario WHERE NOMBRE_USUARIO = ?";

		// Se prepara la consulta para añadirle los parámetros y se ejecuta
		if ($stmt = $dbconnection->prepare($sqlQuery)) {

			/* ligar parámetros para marcadores */
			$stmt->bind_param('s', $_SESSION['username']);

			/* ejecutar la consulta */
			$stmt->execute();

			/* ligar variables de resultado */
			$stmt->bind_result($originalPassword);

			/* obtener valor */
			$stmt->fetch();

			/* Se cierra la consulta */
			$stmt->close();
		}
		else{
			$_SESSION['editAccountError'] = "Error al conectar con la base de datos. Inténtelo de nuevo.";
			header("location: ../view/cuenta/editAccountPage.php");
			exit();
		}

		if (password_verify($_POST['OldPasswd'], $originalPassword)) {
			// Se hashea la nueva password
			$newPostPswd = password_hash($_POST['NewPasswd'], PASSWORD_BCRYPT);

			// Se actualiza en la BD
			$sqlQuery = "UPDATE usuario 
			SET CONTRASENA = ?
			WHERE NOMBRE_USUARIO = ?";

			// Se ejecuta la consulta
			$sqlSTMT = $dbconnection->prepare($sqlQuery);
			$sqlSTMT->bind_param("ss",$newPostPswd,$user);
			$sqlResults=$sqlSTMT->execute();
			$sqlSTMT->close();

			if ($sqlResults !== TRUE){
				$_SESSION['editAccountError'] = "Error al modificar los datos. Inténtelo de nuevo.";
				header("location: ../view/cuenta/editAccountPage.php");
				die();
			}
		}
		else{
			$_SESSION['editAccountError'] = "Contraseña incorrecta. El resto de datos se han actualizado exitosamente.";
			header("location: ../view/cuenta/editAccountPage.php");
			exit();
		}

	}

	/* Se cierra la conexión con la base de datos*/
	$dbconnection->close();
	
	header("location: ../view/cuenta/accountPage.php");
?>
