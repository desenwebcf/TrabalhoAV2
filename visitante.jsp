<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Visitante</title>
</head>

<body>
<form action="ServletVisitante" method="post">
  <table  border="0" cellspacing="0" cellpadding="0" width="100%">
      <tr>
        <td align="right" colspan="2"><font size="+4"> Visitante </font></td>
      </tr>
      <tr>
        <td width="10%">Nome:</td>
        <td><input type="text" name="nome" id="nome" required="required"/></td>
      </tr>
      <tr>
        <td>CPF:</td>
        <td><input type="text" name="cpf" id="cpf" required="required"/></td>
      </tr>
      <tr>
        <td>Endereço:</td>
        <td><input type="text" name="endereco" id="endereco" required="required"/></td>
      </tr>
      <tr>
        <td>CNH:</td>
        <td><input type="text" name="cnh" id="cnh" required="required"/></td>
      </tr>
      <tr>
        <td>Carro:</td>
        <td><input type="text" name="carro" id="carro" required="required"/></td>
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
