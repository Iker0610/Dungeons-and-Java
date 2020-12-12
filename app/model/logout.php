<?php
    /*
    Código tomado de: https://codeshack.io/secure-login-system-php-mysql/:
        Ediciones:
        - Linea 14 (redirección a la página principal)
    */
    
    //Se incia la sesión
    session_start();
    
    // Se destruye la sesión y todos los datos.
    session_destroy();

    // Se redirecciona a la página principal
    header('Location: ../../../index.php');
?>
