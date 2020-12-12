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

	////////////////////////////////////////////////////////////////////////////////////////////////

    // BASE DE DATOS

	// Variables para la base de datos:
	$DATABASE_HOST = '172.17.0.2:3306';
	$DATABASE_USER = 'admin';
	$DATABASE_PASS = 'test';
	$DATABASE_NAME = 'database';

	// Se connecta con la base de datos.
	$dbconnection = mysqli_connect($DATABASE_HOST, $DATABASE_USER, $DATABASE_PASS, $DATABASE_NAME);
	// Check connection
    if (!$dbconnection) {
        die("Connection failed: " . mysqli_connect_error());
    }

    
	

	
    
    ////////////////////////////////////////////////////////////////////////////////////////////////
?>

<!DOCTYPE html>
<html lang="es">

<head>
    <title>Relojería Platas</title>
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
            <?php
					if(isset($_SESSION["username"])){
						echo '<a href="cuenta/accountPage.php"><i class="fas fa-user-circle"></i>',$_SESSION["username"],'</a>';
						echo '<a href="../model/logout.php"><i class="fas fa-sign-out-alt"></i>LogOut</a>';
					}
					else{
						echo '
						<a href="loginPage.php"><i class="fas fa-sign-in-alt"></i>Entrar</a>
						<a href="singupPage.php"><i class="fas fa-user-plus"></i>Nueva cuenta</a>
						';
					}
				?>
        </div>
    </nav>

    <div class="content">
        <div>
            <h2>TUS REPARACIONES</h2>
            <a href="./reparaciones/addReparacionPage.php">
                <i class="fas fa-tools"></i><i class="fas fa-plus" style="font-size: 14px;"></i>
            </a>
        </div>
    

    <!--Lista de reparaciones-->
    <?php
		// Se crea la consulta SQL
		$sqlQuery = "SELECT CODREP, MARCA_RELOJ, FECHA_PETICION, IMPORTE FROM reparacion WHERE DNI_CLIENTE =?  ORDER BY FECHA_PETICION DESC ";
		$sqlSTMT1 = $dbconnection->prepare($sqlQuery);
		$sqlSTMT1->bind_param("s", $_SESSION['dni']);
		$sqlSTMT1->bind_result($cod1, $marca1, $fecha1, $importe1);
		$sqlResults1=$sqlSTMT1->execute();	

		//Se comprueba que haya reparaciones
		$hayDatos = $sqlSTMT1 -> fetch();
		if ($hayDatos){
			// Si hay reparaciones se itera y se genera una pestaña por cada reparación
			while($hayDatos) {
				//Se ajusta la fecha
				$date = date('d-m-Y', strtotime($fecha1)); 
				//Se crea el elemento
				echo "
					</div>
					<div class='elementList'>
						<button class='element'>
							<table>
								<tr>
									<td>
										<b>Código: </b>".$cod1."
									</td>
									<td>
										<b>Fecha: </b>".$date."
									</td>
								</tr>
							</table>
						</button>
						<div class='detailPanel'>
							<table>
								<tr>
									<td>
										<b>Código:&nbsp</b>
									</td>
									<td>
										<p>".$cod1."</p>
									</td>
									<td>
										<b>Marca:&nbsp</b>
									</td>
									<td>
										<p>".$marca1."</p>
									</td>
									<td>
										<b>DNI:&nbsp</b>
									</td>
									<td>
										<p>".$_SESSION['dni']."</p>
									</td>
			
									<td>
										<b>Fecha:&nbsp</b>
									</td>
									<td>
										<p>".$date."</p>
									</td>
									<td>
										<b>Importe:&nbsp</b>
									</td>
									<td>
										<p>".$importe1."&#8364</p>
									</td>";										
									echo '
									<td>
										<form action="./reparaciones/editReparacionPage.php" method="post">
											<input type="hidden" name="codReparacion" value='.$cod1.'>
											<input type="hidden" name="marcaReloj" value='.$marca1.'>
											<input type="hidden" name="fechaPeticion" value='.$date.'>
											<input type="hidden" name="importe" value='.$importe1.'>
											<input type="hidden" name="dniCliente" value='.$_SESSION['dni'].'>
											<button type="submit" class="btn btn-success">
												<i class="fas fa-edit"></i>
											</button>
										</form>
										<form action="../model/deleteReparacion.php" method="post" onSubmit="return confirmarEliminar('."'".$row["CODREP"]."'".')">
											<input type="hidden" name="codReparacion" value='.$cod1.'>
											<button type="submit" class="btn btn-success">
												<i class="iconDelete fas fa-times"></i>
											</button>											
										</form>
									</td>
								</tr>
							</table>
						</div>
					</div>';

				$hayDatos = $sqlSTMT1 -> fetch();
			}
		}
		else{
			echo '
			<div>
				<p> No tienes reparaciones.</p>
			</div>
		</div>';
		}
		$sqlSTMT1->close();
	?>
    </div>

	<div class="content">
        <div>
            <h2>OTRAS REPARACIONES</h2>
        </div>
    

    <!--Lista de reparaciones-->
    <?php
	// Se crea la consulta SQL
		$sqlQuery = "SELECT CODREP, MARCA_RELOJ, FECHA_PETICION, IMPORTE FROM reparacion WHERE DNI_CLIENTE <> ? ORDER BY FECHA_PETICION DESC ";
		$sqlSTMT2 = $dbconnection->prepare($sqlQuery);
		$sqlSTMT2->bind_param("s", $_SESSION['dni']);
		$sqlSTMT2->bind_result($cod2, $marca2, $fecha2, $importe2);
		$sqlResults2=$sqlSTMT2->execute();

		//Se comprueba que haya reparaciones
		$hayDatos = $sqlSTMT2 -> fetch();
		if ($hayDatos){
			// Si hay reparaciones se itera y se genera una pestaña por cada reparación
			while($hayDatos) {
				//Se ajusta la fecha
				$date = date('d-m-Y', strtotime($fecha2)); 
				//Se crea el elemento
				echo "
					</div>
					<div class='elementList'>
						<button class='element'>
							<table>
								<tr>
									<td>
										<b>Código: </b>".$cod2."
									</td>
									<td>
										<b>Fecha: </b>".$date."
									</td>
								</tr>
							</table>
						</button>
						<div class='detailPanel'>
							<table>
								<tr>
									<td>
										<b>Código:&nbsp</b>
									</td>
									<td>
										<p>".$cod2."</p>
									</td>
									<td>
										<b>Marca:&nbsp</b>
									</td>
									<td>
										<p>".$marca2."</p>
									</td>			
									<td>
										<b>Fecha:&nbsp</b>
									</td>
									<td>
										<p>".$date."</p>
									</td>
									<td>
										<b>Importe:&nbsp</b>
									</td>
									<td>
										<p>".$importe2."&#8364</p>
									</td>							
									<td></td>
								</tr>
							</table>
						</div>
					</div>";
					
				$hayDatos = $sqlSTMT2 -> fetch();
			}
		}
		else{
			echo '
			<div>
				<p> No hay otras reparaciones.</p>
			</div>
		</div>';
		}
		$sqlSTMT2->close();
	?>
    </div>

    <script>
    function confirmarEliminar(pCod) {
        var codConfirmacion = prompt(
            "Se dispone a eliminar la reparación con código: " + pCod + "\n\n" +
            "Por razones de seguridad introduzca 'Eliminar " + pCod + "' y pulse aceptar para confirmar.",
            "Introduzca la confirmación")
        return (codConfirmacion === ("Eliminar " + pCod))
    }
    </script>
    <script>
    // Script para la lista de elementos. Fuente: https://www.w3schools.com/howto/howto_js_accordion.asp
    var acc = document.getElementsByClassName("element");
    var i;
    openSeccion = null;

    for (i = 0; i < acc.length; i++) {
        acc[i].addEventListener("click", function() {

            // Se cambia el elemento desplegado
            if (openSeccion && openSeccion !== this) {
                openSeccion.classList.toggle("active");
                var panel = openSeccion.nextElementSibling;
                if (panel.style.maxHeight) {
                    panel.style.maxHeight = null;
                    panel.style.padding = "0 18px";
                } else {
                    panel.style.maxHeight = "max-content";
                    panel.style.padding = "18px 18px 18px 18px";
                }
            }

            // Se cambia el elemento desplegado
            if (openSeccion === this) {
                openSeccion = null;
            } else {
                openSeccion = this
            }
            this.classList.toggle("active");
            var panel = this.nextElementSibling;
            if (panel.style.maxHeight) {
                panel.style.maxHeight = null;
                panel.style.padding = "0 18px";

            } else {
                panel.style.maxHeight = "max-content";
                panel.style.padding = "18px 18px 18px 18px";
            }
        });
    }
    </script>
</body>

</html>

<? 
	$dbconnection->close();	
?>