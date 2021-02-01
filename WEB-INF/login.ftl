<#include "header.ftl">
		<b>Welcome to our little demonstration on the VR Webapp</b><br><br>
		<form method="POST" action="Login?action=tryLogin">
			<fieldset id="login">
				<h3>Log in</h3>
				
				<div>
					<label>Email: </label>
					<input type="text" name="loginEmail">
			    </div>
		
				<div>
					<label>Name: </label>
					<input type="text" name="loginName">
			    </div>
		
			</fieldset>
			<button type="submit" id="loginButton">Log in</button>
		</form>
<#include "footer.ftl">