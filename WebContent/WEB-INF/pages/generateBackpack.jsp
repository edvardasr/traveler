<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>

<head>
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  $( function() {
    $( "#datepicker" ).datepicker({ dateFormat: 'yy-mm-dd' });
  } );
</script>
</head>

<body>
    <h1>Tavo keliautojo gidas, kuprinės sudėtis</h1>
	
    	<form:form method="POST" action="${pageContext.request.contextPath}/generateBackpack" modelAttribute="backpack">
		<table>
			<tr>
				<td><form:label path="distance">Atstumas</form:label></td>
				<td><form:input path="distance" /></td>
			</tr>
			<tr>
				<td><form:label path="bodyWeight">Kūno svoris</form:label></td>
				<td><form:input path="bodyWeight" /></td>
			</tr>
			
			<tr>
				<td><form:label path="date">Data</form:label></td>
				<td><form:input type="text" id="datepicker" path="date" /></td>
			</tr>
			<tr>
				<td><input type="submit" name="submit" value="Generuoti" /></td>
				<td><input type="submit" name="cancel" value="Atmesti" /></td>
			</tr>
		</table>
	</form:form>

</body>
</html>
