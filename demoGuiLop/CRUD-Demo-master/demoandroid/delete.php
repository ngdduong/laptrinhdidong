<?php

    $connection = mysqli_connect("localhost","root","","android");	  
    $id = $_POST["id"];

    $sql = "DELETE FROM data WHERE id='$id'";

    $result = mysqli_query($connection,$sql);

    if($result){
        echo "Data Deleted";

    }
    else{
        echo "Failed";
    }
    mysqli_close($connection);

?>