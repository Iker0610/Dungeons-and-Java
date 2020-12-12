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
    <title>Modificar Reparación</title>
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
            <h2>MODIFICAR REPARACIÓN: <?echo $_POST['codReparacion']?>
            </h2>
            <a href="../home.php"><i class="fas fa-reply"></i></a>
        </div>
        <div>
            <form action="../../model/editReparacion.php" method="post">
                <input type="hidden" name="codigo" value="<?echo $_POST['codReparacion']?>" />
                <table>
                    <tr>
                        <td>
                            <div>
                                <b> Cambiar marca del reloj: </b><br>
                                <input type="text" name="marca" value="<? echo $_POST['marcaReloj'] ?>" />
                            </div>
                        </td>
                        <td>
                            <div>
                                <b> Cambiar importe: </b><br>
                                <input type="text" pattern="^\d+.\d\d$" name="importe"
                                    value="<? echo $_POST['importe'] ?>" />
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div>
                                <b> Cambiar DNI del cliente: </b><br>
                                <input type="text" pattern="[0-9]{8}-[TRWAGMYFPDXBNJZSQVHLCKE]" name="dni"
                                    value="<? echo $_POST['dniCliente'] ?>" />
                            </div>
                        </td>
                        <td>
                            <div>
                                <b> Cambiar fecha de solicitud: </b><br>
                                <input type="text" name="fecha" value="<? echo $_POST['fechaPeticion'] ?>"
                                    pattern="^(?:(?:31(-)(?:0?[13578]|1[02]))\1|(?:(?:29|30)(-)(?:0?[13-9]|1[0-2])\2))(?:(?:1[6-9]|[2-9]\d)?\d{2})$|^(?:29(-)0?2\3(?:(?:(?:1[6-9]|[2-9]\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\d|2[0-8])(-)(?:(?:0?[1-9])|(?:1[0-2]))\4(?:(?:1[6-9]|[2-9]\d)?\d{2})$" />
                            </div>
                        </td>
                    </tr>

                </table>
                <?php
                    if(isset($_SESSION["editRepError"])){
                        $error = $_SESSION["editRepError"];
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
                <input type="submit" value="Actualizar reparación" />
            </form>
        </div>
    </div>
</body>

</html>

<?php
    unset($_SESSION["editRepError"]);
?>