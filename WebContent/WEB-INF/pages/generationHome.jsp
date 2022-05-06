<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
    <h1>Tavo klionės vadovas</h1>
	
    <table>
      <tr>
        <form method="POST" action="/TravelerCalc/generateBackpack" modelAttribute="backpack">
          <td><label>Šis kelionės vadovas padės sugeneruotį į žygį pėščiomis kuprinės sudėtį.
                     Generuokite kuprinės sudėtį.</label></td>
          <td><input type="submit" name="add" value=Pradėti /></td> 
        </form>
      </tr>
    </table>
</body>
</html>
