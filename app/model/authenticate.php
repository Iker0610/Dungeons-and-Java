<?php
    //Se incia la sesión
	session_start();
    
    // Se comprueba que el usuario y la contraseña no sean null
	if ( !isset($_POST['username'], $_POST['password']) ) {
		// Si alguna no existe se muestra un mensaje de error.
        $_SESSION["loginError"] = "Hay que introducir usuario y contraseña.";

        // Se redirige al usuario a la página de LogIn con el error dado
        header("location: ../view/loginPage.php"); 
        die();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

    // BASE DE DATOS

	// Variables para la base de datos:
	$DATABASE_HOST = '172.17.0.2:3306';
	$DATABASE_USER = 'admin';
	$DATABASE_PASS = 'test';
	$DATABASE_NAME = 'database';

	// Se connecta con la base de datos.
	$dbconnection = mysqli_connect($DATABASE_HOST, $DATABASE_USER, $DATABASE_PASS, $DATABASE_NAME);
	//Se comprueba la conexión con la base de datos.
    if (!$dbconnection) {
        die("Connection failed: " . mysqli_connect_error());
    }

    // Se crea la consulta SQL
    $sqlQuery = "SELECT * FROM usuario WHERE NOMBRE_USUARIO = ?";

    // Se prepara la consulta para añadirle los parámetros y se ejecuta
    if ($stmt = $dbconnection->prepare($sqlQuery)) {

        /* ligar parámetros para marcadores */
        $stmt->bind_param('s', $_POST['username']);

        /* ejecutar la consulta */
        $stmt->execute();

        /* ligar variables de resultado */
        $stmt->bind_result($dni, $username, $password, $nombre, $apellido, $telefono, $nacimiento, $email, $IBAN);

        /* obtener valor */
        $stmt->fetch();

        /* Se cierra la consulta */
        $stmt->close();
    }

    /* Se cierra la conexión con la base de datos*/
    $dbconnection->close();
    
    ////////////////////////////////////////////////////////////////////////////////////////////////
    // Se cambia el formato de la fecha:
    $date = date('d-m-Y', strtotime($nacimiento));

    if (password_verify($_POST['password'], $password)) {
        // La verificación ha sido un éxito
        createLog(1);

	    // Creamos las variables de sesión así sabemos qué usuario está conectado
        session_destroy();
        session_start();
        $_SESSION['username'] = $username;
        $_SESSION['nombre'] = $nombre;
        $_SESSION['apellido'] = $apellido;
        $_SESSION['telefono'] = $telefono;
        $_SESSION['nacimiento'] = $date;
        $_SESSION['email'] = $email;
        $_SESSION['dni'] = $dni;
        $_SESSION['iban'] = $IBAN;
        $_SESSION['tiempoExpiracion']= time();
        
        header("location: ../view/home.php");
        die();
    } 
    else {
        // Si el usuario no existe o la contraseña es incorrecta:
        createLog(0);
        
        // Se redirige al usuario a la página de LogIn con el error dado
        $_SESSION["loginError"] = "El usuario o la contraseña son incorrectos";
        
        header("location: ../view/loginPage.php"); 
        die();
    }

    function createLog($resultado){
        //Something to write to txt log
        $log  = "IP:\t\t\t".$_SERVER['REMOTE_ADDR'].PHP_EOL.
                "User:\t\t".$_POST['username'].PHP_EOL.
                "Resultado:\t".($resultado===1?'Success':'Failed').PHP_EOL.
                "Fecha:\t\t".date("d/m/Y - H:i:s").PHP_EOL.
                "-----------------------------------------------------------".PHP_EOL;
        
        //Save string to log, use FILE_APPEND to append.
        file_put_contents("../logs/log_".date("dmY").".log", $log, FILE_APPEND);
    }

?>