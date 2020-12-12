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
            <h2>ACTUALIZAR DATOS PERSONALES</h2>
            <a href="accountPage.php"><i class="fas fa-reply"></i></a>
        </div>
        <div>
            <form action="../../model/editAccount.php" method="post">
                <table>
                    <tr>
                        <td>
                            <div>
                                <b> Cambiar nombre de usuario: </b><br>
                                <input type="text" pattern="[a-zA-Z0-9]+" name="NewUser"
                                    value="<?echo $_SESSION['username']?>" />
                            </div>
                        </td>
                        <td>
                            <div>
                                <b> Cambiar DNI: </b><br>
                                <input type="text" pattern="[0-9]{8}-[A-Za-z]{1}" name="NewDNI"
                                    value="<?echo $_SESSION['dni']?>" />
                            </div>
                        </td>
                        <td>
                            <div>
                                <b> Cambiar email: </b><br>
                                <input type="email" name="NewMail" value="<?echo $_SESSION['email']?>" />
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div>
                                <b>Antigua contraseña:</b><br>
                                <input type="password" name="OldPasswd" pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[\@\$\¿\¡\!\%\*\?\&\#\_])[A-Za-z\d@$¿¡!%*?&#_]{8,}$" placeholder="Contraseña antigua" />
                            </div>
                        </td>
                        <td>
                            <div>
                                <b> Cambiar nombre: </b><br>
                                <!--Regex para aceptar ñ Ñ y acentos en el nombre (obtenido de stackoverflow y comprobado)-->
                                <input type="text"
                                    pattern="^[a-zA-ZÀ-ÿ\u00f1\u00d1]+(\s*[a-zA-ZÀ-ÿ\u00f1\u00d1]*)*[a-zA-ZÀ-ÿ\u00f1\u00d1]+$"
                                    name="NewName" value="<?echo $_SESSION['nombre']?>" />
                            </div>
                        </td>
                        <td>
                            <div>
                                <b> Cambiar teléfono: </b><br>
                                <input type="tel" pattern="[0-9]{9}" name="NewTlf"
                                    value="<?echo $_SESSION['telefono']?>" />
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div>
                                <b>Nueva contraseña:</b>
                                <input type="password" name="NewPasswd" pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[\@\$\¿\¡\!\%\*\?\&\#\_])[A-Za-z\d@$¿¡!%*?&#_]{8,}$" placeholder="Contraseña nueva" />
                            </div>
                        </td>

                        <td>
                            <div>
                                <b> Cambiar apellido: </b><br>
                                <!--Regex para aceptar ñ Ñ y acentos en el nombre (obtenido de stackoverflow y comprobado)-->
                                <input type="text"
                                    pattern="^[a-zA-ZÀ-ÿ\u00f1\u00d1]+(\s*[a-zA-ZÀ-ÿ\u00f1\u00d1]*)*[a-zA-ZÀ-ÿ\u00f1\u00d1]+$"
                                    name="NewSName" value="<?echo $_SESSION['apellido']?>" />
                            </div>
                        </td>
                        <td>
                            <div>
                                <b> Cambiar fecha de nacimiento: </b><br>
                                <!--Regex para comprobar fechas (incluidos años bisiestos)(obtenido de stackoverflow, adaptado y comprobado)-->
                                <input type="text"
                                    pattern="^(?:(?:31(-)(?:0?[13578]|1[02]))\1|(?:(?:29|30)(-)(?:0?[13-9]|1[0-2])\2))(?:(?:1[6-9]|[2-9]\d)?\d{2})$|^(?:29(-)0?2\3(?:(?:(?:1[6-9]|[2-9]\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\d|2[0-8])(-)(?:(?:0?[1-9])|(?:1[0-2]))\4(?:(?:1[6-9]|[2-9]\d)?\d{2})$"
                                    name="NewFNac" value="<?echo $_SESSION['nacimiento']?>" />
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td></td>                        
                        <td>
                            <div>
                                <b> Cambiar IBAN: </b><br>
                                <!--Regex para comprobar IBAN que incluye separación por espacios opcional. Obtenido de https://www.regextester.com/103294-->
                                <input type="text" name="NewIBAN" pattern="([a-zA-Z]{2})\s*\t*(\d{2})\s*\t*(\d{4})\s*\t*(\d{4})\s*\t*(\d{2})\s*\t*(\d{10})" value="<?echo $_SESSION['iban']?>" />
                            </div>
                        </td>
                        <td></td>
                    </tr>
                </table>
                <?php
						if(isset($_SESSION["editAccountError"])){
							$error = $_SESSION["editAccountError"];
                            echo "
                            <tr>
                                <td>
                                    <div class='error'>
                                        <i class='fas fa-exclamation-triangle'></i>
                                        <p>$error</p>
                                        <i class='fas fa-exclamation-triangle'></i>
                                    </div>
                                </td>
                            </tr>";
						}
					?>
                <input type="submit" value="Actualizar cuenta" />
            </form>
        </div>
    </div>
</body>

</html>
<?php
    unset($_SESSION["editAccountError"]);
?>