<?php
    //Se incia la sesión
    session_start();
?>

<!DOCTYPE html>
<html lang="es">

<head>
    <title>Crear Cuenta</title>
    <meta charset="UTF-8">
    <meta name="author" content="Alexander Platas, Iria San Miguel & Iker de la Iglesia">
    <meta name="keywords" content="SGSSI, Proyecto, Web, Relojería">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/style.css" type="text/css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.1/css/all.css">
</head>

<body>
    <nav class="menuPrincipal">
        <div>
            <h1>Relojería Platas</h1>
            <a href="loginPage.php"><i class="fas fa-sign-in-alt"></i>Login</a>
        </div>
    </nav>
    <div class="login">
        <h1>NUEVA CUENTA</h1>
        <form action="../model/createaccount.php" method="post" autocomplete="off">
            <table>
                <tr>
                    <td>
                        <!--usuario-->
                        <label for="username">
                            <i class="fas fa-user"></i>
                        </label>
                        <input type="text" pattern="[a-zA-Z0-9]+" name="username" placeholder="Nombre de usuario (sin espacios)" id="username" required tabindex="1">
                    </td>
                    <td>
                        <!--DNI-->
                        <label for="dni">
                            <i class="fas fa-id-card-alt"></i>
                        </label>
                        <input type="text" name="dni" pattern="[0-9]{8}-[TRWAGMYFPDXBNJZSQVHLCKE]" placeholder="DNI (Ej: 12345678-a)" id="dni" required tabindex="5">
                    </td>
                </tr>
                <tr>
                    <td>
                        <!--contraseña-->
                        <label for="password">
                            <i class="fas fa-lock"></i>
                        </label>
                        <input type="password" name="password" pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[\@\$\¿\¡\!\%\*\?\&\#\_])[A-Za-z\d@$¿¡!%*?&#_]{8,}$" placeholder="Introduce una nueva contraseña" id="password" required tabindex="2">
                    </td>
                    <td>
                        <!--nombre-->
                        <label for="nombre">
                            <i class="fas fa-address-card"></i>
                        </label>
                        <!--Regex para aceptar ñ Ñ y acentos en el nombre (obtenido de stackoverflow y comprobado)-->
                        <input type="text" name="nombre" pattern="^[a-zA-ZÀ-ÿ\u00f1\u00d1]+(\s*[a-zA-ZÀ-ÿ\u00f1\u00d1]*)*[a-zA-ZÀ-ÿ\u00f1\u00d1]+$" placeholder="Nombre (únicamente letras)" id="nombre" required tabindex="6">
                    </td>
                </tr>
                <tr>
                    <td>
                        <!--email-->
                        <label for="email">
                            <i class="fas fa-envelope"></i>
                        </label>
                        <input type="email" name="email" placeholder="eMail (Ej: ejemplo@gmail.com)" id="email" required tabindex="3">
                    </td>
                    <td>
                        <!--apellido-->
                        <label for="apellido">
                            <i class="far fa-address-card"></i>
                        </label>
                        <input type="text" name="apellido" pattern="^[a-zA-ZÀ-ÿ\u00f1\u00d1]+(\s*[a-zA-ZÀ-ÿ\u00f1\u00d1]*)*[a-zA-ZÀ-ÿ\u00f1\u00d1]+$" placeholder="Apellido (únicamente letras)" id="apellido" required tabindex="7">
                    </td>
                </tr>
                <tr>
                    <td>
                        <!--telefono-->
                        <label for="telefono">
                            <i class="fas fa-mobile-alt"></i>
                        </label>
                        <input  type="tel" pattern="[0-9]{9}" name="telefono" placeholder="Teléfono (Ej: 612345789)" id="telefono" tabindex="4">
                    </td>
                    <td>
                        <!--fecha de nacimiento-->
                        <label for="fechaN">
                            <i class="far fa-calendar-alt"></i>
                        </label>
                        <!--Regex para comprobar fechas (incluidos años bisiestos)(obtenido de stackoverflow, adaptado y comprobado)-->
                        <input type="text" pattern="^(?:(?:31(-)(?:0?[13578]|1[02]))\1|(?:(?:29|30)(-)(?:0?[13-9]|1[0-2])\2))(?:(?:1[6-9]|[2-9]\d)?\d{2})$|^(?:29(-)0?2\3(?:(?:(?:1[6-9]|[2-9]\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\d|2[0-8])(-)(?:(?:0?[1-9])|(?:1[0-2]))\4(?:(?:1[6-9]|[2-9]\d)?\d{2})$" 
                        name="fechaN" placeholder="Fecha de nacimiento (dd-mm-aaaa)" id="fechaN" required tabindex="8">
                    </td>
                </tr>
                </table>
                <div class="singUpLastElement">
                    <!--Número Bancario-->
                    <label for="iban">
                        <i class="fas fa-money-check-alt"></i>
                    </label>
                    <!--Regex para comprobar IBAN que incluye separación por espacios opcional. Obtenido de https://www.regextester.com/103294-->
                    <input type="text" name="iban" placeholder="IBAN (Ej:)" pattern="([a-zA-Z]{2})\s*\t*(\d{2})\s*\t*(\d{4})\s*\t*(\d{4})\s*\t*(\d{2})\s*\t*(\d{10})" id="iban" required tabindex="9">
                </div>
  

            
            <?php
                if(isset($_SESSION["createAccountError"])){
                    $error = $_SESSION["createAccountError"];
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
            <!--boton de crear-->
            <input type="submit" value="CREAR CUENTA NUEVA" tabindex="9">
        </form>
    </div>
</body>

</html>

<?php
	unset($_SESSION["createAccountError"]);
?>
