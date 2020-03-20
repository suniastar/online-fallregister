import React from 'react';
import './App.css';

function App() {
  return (
    <div className="App">
      <header className="App-header">
      <form action="/action_page.php">
        <p>Patientendaten</p>
  <label for="fname">First name:</label>
  <input type="text" id="fname" name="fname"></input>
  <label for="lname">Last name:</label>
  <input type="text" id="lname" name="lname"></input>
  <input type="submit" value="Submit"></input>
</form>
      </header>
    </div>
  );
}

export default App;
