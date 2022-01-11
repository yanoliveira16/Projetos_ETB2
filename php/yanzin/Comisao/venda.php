<!DOCTYPE html>
<html>
<head>
</head>
<body>
  <?php
	 echo"<h1>Comissao</h1>";
	 $nome=$_POST["nome"];
	 $sal=$_POST["sal"];
	 $comissao=$_POST["venda"];
	 $resl=$comissao*.15+$sal;
	 echo"<p>seu salario com comissao é:R$$resl</p>";
	 ?>
</body>
</html>