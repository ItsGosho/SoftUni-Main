<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FDMC</title>
</head>
<body>
    <h1>Create a Cat!</h1>
    <br/>
    <form method="post" action="/cats/create">
        Name: <input type="text" name="name" /><br/>
        Breed: <input type="text" name="breed" /><br/>
        Color: <input type="text" name="color" /><br/>
        Number Of Legs: <input type="number" name="numberOfLegs" /><br/>
        <button type="submit">Create Cat</button>
    </form>
    <br/>
    <a href="/">Back to Home</a>
</body>
</html>
