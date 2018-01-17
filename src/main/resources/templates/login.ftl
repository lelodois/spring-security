<#import "static.ftl" as static>
<!DOCTYPE html>
<html lang="en">
	<head>
	    <meta charset="utf-8">
		<@static.css/>
		<@static.js/>
	</head>
	<body>
		<h1>Login</h1>
		
		<form role="form" action="/login" method="post">
		    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		
		    <div >
		        <label for="email">Email address</label>
		        <input type="email" name="email" id="email" required autofocus/>
		    </div>
		    <div>
		        <label for="password">Password</label>
		        <input type="password" name="password" id="password" required/>
		    </div>
		    <div>
		        <label for="remember-me">Remember me</label>
		        <input type="checkbox" name="remember-me" id="remember-me"/>
		    </div>
		    
		    <button type="submit">Login</button>
		</form>
		
		<#if error.isPresent()>
			<p>The email or password you have entered is invalid, try again.</p>
		</#if>
	</body>
</html>
