import React from 'react';
import './App.css';

function App() {
    return (
        <div className="App">
            <header className="App-header">
                <form action="/action_page.php">
                    <h>Patientendaten</h>
                    <br></br>
                    <label for="fname">Vorname:</label>
                    <input type="text" id="fname" name="fname"></input>
                    <br></br>
                    <label for="lname">Nachname:</label>
                    <input type="text" id="lname" name="lname"></input>
                    <br></br>
                    <label htmlFor="gender">Geschlecht:</label>
                    <input type="text" id="gender" name="gender"></input>
                    <br></br>
                    <label for="birthday">Geburtsdatum:</label>
                    <input type="text" id="birthday" name="birthday"></input>
                    <br></br>
                    <label htmlFor="address">Adresse:</label>
                    <input type="text" id="address" name="address"></input>
                    <br></br>
                    <label htmlFor="email">Email:</label>
                    <input type="text" id="email" name="email"></input>
                    <br></br>
                    <label htmlFor="telephonenumber">Telefonnummer:</label>
                    <input type="text" id="telephonenumber" name="telephonenumber"></input>
                    <br></br>
                    <label htmlFor="activity">Tätigkeit:</label>
                    <input type="text" id="activity" name="activity"></input>
                    <br></br>
                    <label htmlFor="care">Betreuung:</label>
                    <input type="text" id="care" name="care"></input>
                    <br></br>
                    <label htmlFor="stay">Unterbringung:</label>
                    <input type="text" id="stay" name="stay"></input>
                    <br></br>
                    <label htmlFor="diagnose">Diagnose/Verdachtsdiagnose:</label>
                    <input type="text" id="diagnose" name="diagnose"></input>
                    <br></br>
                    <label htmlFor="stay">Unterbringung:</label>
                    <input type="text" id="stay" name="stay"></input>
                    <br></br>
                    <label htmlFor="dayOfInfection">Tag der Erkrankung:</label>
                    <input type="text" id="dayOfInfection" name="dayOfInfection"></input>
                    <br></br>
                    <label htmlFor="dayOfDiagnose">Tag der Diagnose:</label>
                    <input type="text" id="dayOfDiagnose" name="dayOfDiagnose"></input>
                    <br></br>
                    <label htmlFor="dayOfDeath">Tag des Todes:</label>
                    <input type="text" id="dayOfDeath" name="dayOfDeath"></input>
                    <br></br>
                    <label htmlFor="timeslotOfInfection">Zeitraum der Infektion:</label>
                    <input type="text" id="timeslotOfInfection" name="timeslotOfInfection"></input>
                    <br></br>
                    <label htmlFor="infectionSource">Infektionsquelle:</label>
                    <input type="text" id="infectionSource" name="infectionSource"></input>
                    <br></br>
                    <label htmlFor="infectionPlace">Infektionsort:</label>
                    <input type="text" id="infectionPlace" name="infectionPlace"></input>
                    <br></br>
                    <label htmlFor="transfer">Überweisung:</label>
                    <input type="text" id="transfer" name="transfer"></input>
                    <br></br>
                    <label htmlFor="admission">Aufnahme:</label>
                    <input type="text" id="admission" name="admission"></input>
                    <br></br>
                    <label htmlFor="dismissal">Entlassung:</label>
                    <input type="text" id="dismissal" name="dismissal"></input>
                    <br></br>
                    <br></br>

                    <h>Labor</h>
                    <br></br>
                    <label for="fname">First name:</label>
                    <input type="text" id="fname" name="fname"></input>
                    <br></br>
                    <label for="lname">Last name:</label>
                    <input type="text" id="lname" name="lname"></input>
                    <br></br>
                    <label for="birthday">Telefonnummer:</label>
                    <input type="text" id="telephonenumber" name="telephonenumber"></input>
                    <br></br>
                    <label htmlFor="birthday">Email:</label>
                    <input type="text" id="email" name="email"></input>
                    <br></br>
                    <label htmlFor="birthday">Untersuchungsstelle:</label>
                    <input type="text" id="labor" name="labor"></input>
                    <br></br>

                    <br></br>
                    <h>Melder</h>
                    <br></br>
                    <label htmlFor="fname">First name:</label>
                    <input type="text" id="fname" name="fname"></input>
                    <br></br>
                    <label htmlFor="lname">Last name:</label>
                    <input type="text" id="lname" name="lname"></input>
                    <br></br>
                    <label htmlFor="birthday">Anschrift:</label>
                    <input type="text" id="address" name="address"></input>
                    <br></br>
                    <label htmlFor="birthday">Email:</label>
                    <input type="text" id="email" name="email"></input>
                    <br></br>
                    <label htmlFor="birthday">Telefonnummer:</label>
                    <input type="text" id="telephonnumber" name="telephonenumber"></input>
                    <br></br>

                    <br></br>

                    <input type="submit" value="Submit"></input>
                </form>
            </header>
        </div>
    );
}

export default App;
