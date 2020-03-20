import React from 'react';
import './App.css';

function App() {
  return (
    <div className="App">
      <header className="App-header">
      <form action="/action_page.php">
        <h>Patientendaten</h>
        <br></br>
        <br></br>
  <label for="fname">First name:</label>
  <input type="text" id="fname" name="fname"></input>
  <br></br>
  <label for="lname">Last name:</label>
  <input type="text" id="lname" name="lname"></input>
  <br></br>
  <label for="birthday">Geburtsdatum:</label>
  <input type="text" id="birthday" name="birthday"></input>
  <br></br>
  <br></br>
  
  <input type="submit" value="Submit"></input>
</form>
      </header>
    </div>
  );
}

export default App;
