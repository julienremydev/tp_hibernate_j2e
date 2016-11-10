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
	<form id="inscriptionParticulier" method="post" action="<c:url value="/index"/>">
		<h1>Inscription Particulier</h1>
		<fieldset id="inputs">
			<input name="login" type="text" placeholder="Login" required>
			<input name="mdp" type="password" placeholder="Mot de passe" required>
			<input name="nom" type="text" placeholder="Nom" required>
			<input name="prenom" type="text" placeholder="Prenom" required>
		</fieldset>
		<fieldset id="actions">
			<input type="submit" id="submit" name="inscriptionParticulier"
				value="Valider">
		</fieldset>
	</form>
	<form id="inscriptionEntreprise" method="post" action="<c:url value="/index"/>">
		<h1>Inscription Entreprise</h1>
		<fieldset id="inputs">
			<input name="login" type="text" placeholder="Login" required>
			<input name="mdp" type="password" placeholder="Mot de passe" required>
			<input name="raisonSociale" type="text" placeholder="Raison Sociale" required>
		</fieldset>
		<fieldset id="actions">
			<input type="submit" id="submit" name="inscriptionEntreprise"
				value="Valider">
		</fieldset>
	</form>
	<form id="login" method="post" action="<c:url value="/index"/>">
		<h1>Connexion</h1>
		<fieldset id="inputs">
			<input name="login" type="text" placeholder="Login" required>
			<input name="mdp" type="password" placeholder="Mot de passe" required>
		</fieldset>
		<fieldset id="actions">
			<input type="submit" id="submit" name="connexion" value="Valider">
		</fieldset>
	</form>
</body>

</html>
