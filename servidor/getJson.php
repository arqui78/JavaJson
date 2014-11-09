<?php
class Conexion{
    
    function conectarBD(){ 
            $server = "localhost";
            $usuario = "miusurio";
            $pass = "miclave";
            $BD = "midb";            
            $conexion = mysqli_connect($server, $usuario, $pass, $BD);         
            if(!$conexion){ 
               echo 'Error en la conexion a la base de datos<br>'; 
            }             
            return $conexion; 
    }      

    function desconectarBD($conexion){            
            $close = mysqli_close($conexion);         
            if(!$close){  
               echo 'Error en la desconexion de la base de datos<br>'; 
            }                
            return $close;         
    }
    
    function getSQL($sql){        
        $conexion = $this->conectarBD();    
        if(!$result = mysqli_query($conexion, $sql)) die();

        $data = array();
        
        $i=0;
        while($filas = mysqli_fetch_array($result))
        {           
            $data[$i] = $filas;
            $i++;
        }        
        $this->desconectarBD($conexion);
        return $data;
    }
    

    function getData(){        
        $sql = "SELECT * FROM mitabla;";    
        return $this->getSQL($sql);
    }    
}

$objConexion = new Conexion();
$datos = $objConexion->getData();
echo json_encode($datos);    

?>