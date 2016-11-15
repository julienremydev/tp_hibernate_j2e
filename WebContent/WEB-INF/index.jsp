<%@ page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Accueil</title>
<link type="text/css" rel="stylesheet"
	href="<c:url value="/include/style.css"/>" />
</head>
<body>
	<div>
		<p class="info">${ message }</p>
	</div>

	<div class="form">

		<ul class="tab-group">
			<li class="tab"><a href="#signup_p">Particulier</a></li>
			<li class="tab"><a href="#signup_e">Entreprise</a></li>
			<li id="login-tab" class="tab active"><a href="#login">Connexion</a></li>
		</ul>

		<div class="tab-content">
			<div class = "subscribe" id="signup_p">
				<h1>Inscription</h1>

				<form id="inscriptionParticulier" method="post"
					action="<c:url value="/index"/>">

					<div class="top-row">
						<div class="field-wrap">
							<label> Login<span class="req">*</span>
							</label> <input name="login" type="text" placeholder="Login" required
								autocomplete="off">
						</div>

						<div class="field-wrap">
							<label> Mot de passe<span class="req">*</span>
							</label> <input name="mdp" type="password" placeholder="Mot de passe"
								required autocomplete="off">
						</div>

					</div>
					<div class="field-wrap">
						<label> Nom<span class="req">*</span> </label><input name="nom"
							type="text" placeholder="Nom" required>
					</div>

					<div class="field-wrap">
						<label> Prénom<span class="req">*</span></label> <input
							name="prenom" type="text" placeholder="Prenom" required>
					</div>


					<button name="inscriptionParticulier" type="submit"
						class="button button-block" >
					Go
					</button>

				</form>

			</div>

			<div class = "subscribe" id="signup_e">
				<h1>Inscription</h1>

				<form id="inscriptionEntreprise" method="post" action="<c:url value="/index"/>">

					<div class="top-row">
						<div class="field-wrap">
							<label> Login<span class="req">*</span>
							</label> <input name="login" type="text" placeholder="Login" required
								autocomplete="off">
						</div>

						<div class="field-wrap">
							<label> Mot de passe<span class="req">*</span>
							</label> <input name="mdp" type="password" placeholder="Mot de passe"
								required autocomplete="off">
						</div>

					</div>
					<div class="field-wrap">
						<label> Raison Sociale<span class="req">*</span> </label><input name="raisonSociale" type="text" placeholder="Raison Sociale" required>
					</div>


					<button name="inscriptionEntreprise" type="submit"
						class="button button-block" >
					Go
					</button>

				</form>

			</div>


			<div id="login">
				<h1>Welcome Back!</h1>

				<form id="login" method="post" action="<c:url value="/index"/>">

					<div class="top-row">
						<div class="field-wrap">
							<label> Login<span class="req">*</span>
							</label> <input name="login" type="text" placeholder="Login" required
								autocomplete="off">
						</div>

						<div class="field-wrap">
							<label> Mot de passe<span class="req">*</span>
							</label> <input name="mdp" type="password" placeholder="Mot de passe"
								required autocomplete="off">
						</div>

					</div>
					<button name="connexion" type="submit"
						class="button button-block" >
					Go
					</button>

				</form>

			</div>

		</div>
		<!-- tab-content -->

	</div>
	<!-- /form -->

	<script
		src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
	<script src="<c:url value="/include/index.js"/>"></script>

</body>

</html>
