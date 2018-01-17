<#import "static.ftl" as static>
<!DOCTYPE html>
<html lang="en">
	<head>
	    <meta charset="utf-8">
		<@static.css/>
		<@static.js/>
	</head>
	<body>
		<h1>Home</h1>
		<ul>
		    <#if !currentUser??>
		        <li><a href="/login">Log in</a></li>
		    </#if>
		    <#if currentUser??>
		        <li>
		            <form action="/logout" method="post">
		                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		                <button type="submit">Log out</button>
		            </form>
		        </li>
		        <li><a href="/user/${currentUser.id}">View myself</a></li>
		    </#if>
		    <#if currentUser?? && currentUser.role == "ADMIN">
		        <li><a href="/user/create">Create a new user</a></li>
		        <li><a href="/user/all">View all users</a></li>
		    </#if>
		</ul>
	</body>
<html>