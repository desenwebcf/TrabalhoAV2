<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Carro</title>
</head>
<link href="css/css_Geral.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="Demo/demo.css" type="text/css" media="all" />
<body>


<form action="ServletCarro" method="post">
    <table  border="0" cellspacing="0" cellpadding="0" width="100%" class="textoGeral">
      <tr>
        <td align="right" colspan="2"><font size="+4"> <%@include file="menu.jsp" %> </font></td>
      </tr>
       <tr>
        <td align="right" colspan="2"><font size="+4">&nbsp;  </font></td>
      </tr>
        <tr>
        <td align="right" colspan="2"><font size="+4"> Carro </font></td>
      </tr>
      <tr>
        <td width="10%">Renavam:</td>   
        <td><input type="text" name="renavam" id="renavam" required="required"/></td>
      </tr>
      <tr>
        <td>Placa:</td>
        <td><input type="text" name="placa" id="placa" required="required"/></td>
      </tr>
      <tr>
        <td>Modelo:</td>
        <td><input type="text" name="modelo" id="modelo" required="required"/></td>
      </tr>
      <tr>
        <td>Ano:</td>
        <td><select name="ano">
            <option>Selecione o ano</option>
            <option>2000</option>
            <option>2001</option>
            <option>2002</option>
            <option>2003</option>
            <option>2004</option>
            <option>2005</option>
            <option>2006</option>
            <option>2007</option>
            <option>2008</option>
            <option>2009</option>
            <option>2010</option>
            <option>2011</option>
            <option>2012</option>
            <option>2013</option>
        </select></td>
      </tr>
      <tr>
        <td>Cor:</td>
        <td><input type="text" name="cor" id="cor" required="required"/></td>
      </tr>
      <tr>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td><input type="submit" Value="Cadastrar"/><input type="reset" Value="Limpar"/></td>
      </tr>
  </table>
    

  </form>
</body>
</html>
