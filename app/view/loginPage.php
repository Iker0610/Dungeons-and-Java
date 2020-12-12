<?php
    /*
    Código tomado de: https://codeshack.io/secure-login-system-php-mysql/
	    Ediciones:
	    - meta data, links, diseño del formulario -> adición de una tabla, mensaje de error, validación...
    */
    
    //Se incia la sesión
    session_start();
?>

<!DOCTYPE html>
<html lang="es">

<head>
    <title>Log In</title>
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
            <a href="singupPage.php"><i class="fas fa-user-plus"></i>Crear cuenta</a>
        </div>
    </nav>
    <div class="login">
        <h1>REGISTRARSE</h1>
        <form action="../model/authenticate.php" method="post">

            <table>
                <tr>
                    <td>
                        <label for="username">
                            <i class="fas fa-user"></i>
                        </label>
                        <input type="text" name="username" pattern="[a-zA-Z0-9]+" placeholder="Usuario" id="username" required>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="password">
                            <i class="fas fa-lock"></i>
                        </label>
                        <input type="password" name="password" pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[\@\$\¿\¡\!\%\*\?\&\#\_])[A-Za-z\d@$¿¡!%*?&#_]{8,}$"1 placeholder="Contraseña" id="password" required>
                    </td>
                </tr>
            </table>
            <?php
                if(isset($_SESSION["loginError"])){
                    $error = $_SESSION["loginError"];
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
            <input type="submit" value="Login">
        </form>
    </div>
</body>

</html>

<?php
    unset($_SESSION["loginError"]);
?>