<#import "static.ftl" as static>
<!DOCTYPE html>
<html lang="en">
	<head>
	    <meta charset="utf-8">
		<@static.css/>
		<@static.js/>
	</head>
	<body>
		<nav role="navigation">
		    <ul>
		        <li><a href="/">Home</a></li>
		    </ul>
		</nav>
		
		<h1>User details</h1>
		
		<p>E-mail: ${user.email}</p>
		
		<p>Role: ${user.role}</p>
	</body>
</html>