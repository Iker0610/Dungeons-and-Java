<?php
	//Se incia la sesión
	session_start();

	//Si no se ha iniciado sesión se le redirige a la página principal
	if(!isset($_SESSION["username"])){
		header("location: ../../index.php");
		die();
	}
	// Si ha iniciado sesión se comprueba que no haya estado inactivo mucho tiempo
	else if (time() > $_SESSION['tiempoExpiracion'] + 60){ 
		session_destroy();
		session_start();
		$_SESSION["loginError"] = "Sesión cerrada por inactividad";
		header("location: ../../index.php"); 
		die();
	}
	$_SESSION['tiempoExpiracion']=time();
?>

<!DOCTYPE html>
<html lang="es">

<head>
    <title>Relojería Platas</title>
    <meta charset="UTF-8">
    <meta name="author" content="Alexander Platas, Iria San Miguel & Iker de la Iglesia">
    <meta name="keywords" content="SGSSI, Proyecto, Web, Relojería">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../../css/style.css" type="text/css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.1/css/all.css">
</head>

<body>
    <nav class="menuPrincipal">
        <div>
            <h1>Relojería Platas</h1>

            <a href="../home.php"><i class="fa fa-home"></i>Home</a>
            <a href="../../model/logout.php"><i class="fas fa-sign-in-alt"></i>LogOut</a>

        </div>
    </nav>
    <div class="content">
		<div>
			<h2>DATOS DE LA CUENTA</h2>
			<a href="editAccountPage.php">
				<i class="fas fa-user-edit"></i>
			</a>
        </div>
        <div>
			<table>
				<tr>
					<td>
						<b>Usuario: </b>
					</td>
					<td>
						<p><?echo $_SESSION["username"]?></p>
					</td>
					<td>
						<b>DNI: </b>
					</td>
					<td>
						<p><?echo $_SESSION["dni"]?></p>
					</td>
				</tr>

				<tr>
					<td>
						<b>eMail: </b>
					</td>
					<td>
						<p><?echo $_SESSION["email"]?></p>
					</td>
					<td>
						<b>Nombre: </b>
					</td>
					<td>
						<p><?echo $_SESSION["nombre"]?></p>
					</td>					
				</tr>

				<tr>
					<td>
						<b>Teléfono: </b>
					</td>
					<td>
						<p><?echo $_SESSION["telefono"]?></p>
					</td>
					<td>
						<b>Apellido: </b>
					</td>
					<td>
						<p><?echo $_SESSION["apellido"]?></p>
					</td>
				</tr>

				<tr>								
					<td>
						<b>Fecha de nacimiento: </b>
					</td>									
					<td>
						<p><?echo $_SESSION["nacimiento"]?></p>
					</td>
					<td>
						<b>IBAN: </b>
					</td>
					<td>
						<p><?echo $_SESSION["iban"]?></p>
					</td>
				</tr>
			</table>
		</div>
    </div>
</body>

</html>