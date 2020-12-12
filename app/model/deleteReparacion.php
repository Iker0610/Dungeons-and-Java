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

    
    // BASE DE DATOS

	// Variables para la base de datos:
	$DATABASE_HOST = '172.17.0.2:3306';
	$DATABASE_USER = 'admin';
	$DATABASE_PASS = 'test';
	$DATABASE_NAME = 'database';

	// Se connecta con la base de datos.
	$dbconnection = mysqli_connect($DATABASE_HOST, $DATABASE_USER, $DATABASE_PASS, $DATABASE_NAME);
	// Se comprueba la conexión con la base de datos
    if (!$dbconnection) {
        die("Connection failed: " . mysqli_connect_error());
    }

    // Se crea la consulta SQL
    $sqlQuery = "DELETE FROM reparacion WHERE CODREP=?";
    $sqlSTMT = $dbconnection->prepare("DELETE FROM reparacion WHERE CODREP=?");
    $sqlSTMT->bind_param("s", $_POST['codReparacion']);
    $sqlResults=$sqlSTMT->execute();
	$sqlSTMT->close();
    ////////////////////////////////////////////////////////////////////////////////////////////////

    header("location: ../view/home.php");
?>
