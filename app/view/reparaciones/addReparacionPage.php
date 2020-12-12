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
    <title>Añadir Reparación</title>
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
            <h2>AÑADIR REPARACIÓN</h2>
            <a href="../home.php"><i class="fas fa-reply"></i></a>
        </div>
        <div>
            <form action="../../model/addReparacion.php" method="post">
                <table>
                    <tr>
                        <td>
                            <div>
                                <b> Marca del reloj: </b><br>
                                <input type="text" name="marca" placeholder="Marca del reloj." />
                            </div>
						</td>
						<td>
                            <div>
                                <b> Importe: </b><br>
                                <input type="text" pattern="^\d+.\d\d$" name="importe" placeholder="Importe. (18.95)" />
                            </div>
                        </td>
                    </tr>
                    <tr>
						<td>
                            <div>
                                <b> DNI del cliente: </b><br>
                                <input type="text" pattern="[0-9]{8}-[TRWAGMYFPDXBNJZSQVHLCKE]" name="dni"
                                    placeholder="DNI. Ejemplo: 12345678-a" />
                            </div>
                        </td>
                        <td>
                            <div>
                                <b> Fecha de solicitud: </b><br>
                                <!--Regex para comprobar fechas (incluidos años bisiestos)(obtenido de stackoverflow, adaptado y comprobado)-->
                                <input type="text" name="fecha" placeholder="Fecha. (dd-mm-aaaa)"
                                    pattern="^(?:(?:31(-)(?:0?[13578]|1[02]))\1|(?:(?:29|30)(-)(?:0?[13-9]|1[0-2])\2))(?:(?:1[6-9]|[2-9]\d)?\d{2})$|^(?:29(-)0?2\3(?:(?:(?:1[6-9]|[2-9]\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\d|2[0-8])(-)(?:(?:0?[1-9])|(?:1[0-2]))\4(?:(?:1[6-9]|[2-9]\d)?\d{2})$" />
                            </div>
                        </td>
                        
                    </tr>
				</table>
                <?php
                    if(isset($_SESSION["addRepError"])){
                        $error = $_SESSION["addRepError"];
                        echo "
                        <tr>
                        <td><div class='error'>
                            <i class='fas fa-exclamation-triangle'></i>
                            <p>$error</p>
                            <i class='fas fa-exclamation-triangle'></i>
                        </div></td>
                    </tr>";
                    }
                ?>
				<input type="submit" value="Crear reparación" />
            </form>
        </div>
    </div>
</body>

</html>

<?php
    unset($_SESSION["addRepError"]);
?>