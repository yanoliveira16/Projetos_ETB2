<!DOCTYPE html>
<html>
<head>
	
</head>
<body>
	<?php
	
	 

	 $n1=$_POST["n1"];
	 $n2=$_POST["n2"];
	 $n3=$_POST["n3"];

     if (($n1<=$n2 +$n3) and ($n2 <=$n1 + $n3) and ($n3<=$n1+$n2))
     echo"<p> Os valoers fornecidos forma um triangulo</p>"

     else if(($n1 ==$n2) and ($n1 == $n3){
     	echo"<p> Triangulo Equilatero</p>"
     }
     else if(($n1 == $n2) or ($n1 == $n3) or ($n2 == $n3){
        echo"<p>Triangulo isoceles</p>"
        else{
        	echo"<p>Triangulo Escaleno</p>"
        }

     }
    
    else{
    	echo"<p>Os valores fornecidos nao formam um triangulo</p>"
    }
 }
     }
	 

?>
</body>
</html>