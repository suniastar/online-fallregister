import React from 'react';
//import './App.css';
import './App_light.css';
import {Label, Input} from '@material-ui/core/';

function App() {
    return (
        <div className="App">
            <header className="App-header">
                <form action="/action_page.php">

                    <h>Patientendaten</h>
                    <br></br>
                    <label for="fname">Vorname:</label>
                    <br></br><input type="text" id="fname" name="fname"></input>
                    <br></br>
                    <label for="lname">Nachname:</label>
                    <br></br><input type="text" id="lname" name="lname"></input>
                    <br></br>
                    <label htmlFor="gender">Geschlecht:</label>
                    <br></br>
                    <select id="gender" name="gender">
                    <option value="" disabled selected>Select your option</option>
                    <option value="male">Männlich</option>
                    <option value="female">Weiblich</option>
                    <option value="other">Sonstiges</option>
                    </select><br></br>
                    <label for="birthday">Geburtsdatum:</label>
                    <br></br><input type="text" id="birthday" name="birthday"></input>
                    <br></br>
                    <label htmlFor="address">Adresse:</label>
                    <br></br><input type="text" id="address" name="address"></input>
                    <br></br>
                    <label htmlFor="email">Email:</label>
                    <br></br><input type="text" id="email" name="email"></input>
                    <br></br>
                    <label htmlFor="telephonenumber">Telefonnummer:</label>
                    <br></br><input type="text" id="telephonenumber" name="telephonenumber"></input>
                    <br></br>
                    <label htmlFor="activity">Tätigkeit:</label>
                    <br></br><input type="text" id="activity" name="activity"></input>
                    <br></br>
                    <label htmlFor="care">Betreuung:</label>
                    <br></br><input type="text" id="care" name="care"></input>
                    <br></br>
                    <label htmlFor="stay">Unterbringung:</label>
                    <br></br><input type="text" id="stay" name="stay"></input>
                    <br></br>
                    <label htmlFor="diagnose">Diagnose/Verdachtsdiagnose:</label>
                    <br></br><input type="text" id="diagnose" name="diagnose"></input>
                    <br></br>
                    <label htmlFor="stay">Unterbringung:</label>
                    <br></br><input type="text" id="stay" name="stay"></input>
                    <br></br>
                    <label htmlFor="dayOfInfection">Tag der Erkrankung:</label>
                    <br></br><input type="text" id="dayOfInfection" name="dayOfInfection"></input>
                    <br></br>
                    <label htmlFor="dayOfDiagnose">Tag der Diagnose:</label>
                    <br></br><input type="text" id="dayOfDiagnose" name="dayOfDiagnose"></input>
                    <br></br>
                    <label htmlFor="dayOfDeath">Tag des Todes:</label>
                    <br></br><input type="text" id="dayOfDeath" name="dayOfDeath"></input>
                    <br></br>
                    <label htmlFor="timeslotOfInfection">Zeitraum der Infektion:</label>
                    <br></br><input type="text" id="timeslotOfInfection" name="timeslotOfInfection"></input>
                    <br></br>
                    <label htmlFor="infectionSource">Infektionsquelle:</label>
                    <br></br><input type="text" id="infectionSource" name="infectionSource"></input>
                    <br></br>
                    <label htmlFor="infectionPlace">Infektionsort:</label>
                    <br></br><input type="text" id="infectionPlace" name="infectionPlace"></input>
                    <br></br>
                    <label htmlFor="transfer">Überweisung:</label>
                    <br></br><input type="text" id="transfer" name="transfer"></input>
                    <br></br>
                    <label htmlFor="admission">Aufnahme:</label>
                    <br></br><input type="text" id="admission" name="admission"></input>
                    <br></br>
                    <label htmlFor="dismissal">Entlassung:</label>
                    <br></br><input type="text" id="dismissal" name="dismissal"></input>
                    <br></br>
                    <br></br>

                    <h>Labor</h>
                    <br></br>
                    <label for="fname">First name:</label>
                    <br></br><input type="text" id="fname" name="fname"></input>
                    <br></br>
                    <label for="lname">Last name:</label>
                    <br></br><input type="text" id="lname" name="lname"></input>
                    <br></br>
                    <label for="birthday">Telefonnummer:</label>
                    <br></br><input type="text" id="telephonenumber" name="telephonenumber"></input>
                    <br></br>
                    <label htmlFor="birthday">Email:</label>
                    <br></br><input type="text" id="email" name="email"></input>
                    <br></br>
                    <label htmlFor="birthday">Untersuchungsstelle:</label>
                    <br></br><input type="text" id="labor" name="labor"></input>
                    <br></br>

                    <br></br>
                    <h>Melder</h>
                    <br></br>
                    <label htmlFor="fname">First name:</label>
                    <br></br><input type="text" id="fname" name="fname"></input>
                    <br></br>
                    <label htmlFor="lname">Last name:</label>
                    <br></br><input type="text" id="lname" name="lname"></input>
                    <br></br>
                    <label htmlFor="birthday">Anschrift:</label>
                    <br></br><input type="text" id="address" name="address"></input>
                    <br></br>
                    <label htmlFor="birthday">Email:</label>
                    <br></br><input type="text" id="email" name="email"></input>
                    <br></br>
                    <label htmlFor="birthday">Telefonnummer:</label>
                    <br></br><input type="text" id="telephonnumber" name="telephonenumber"></input>
                    <br></br>

                    <br></br><input type="submit" value="Submit"></input>
                    <br></br><br></br>
                </form>
            </header>
        </div>
    );
}

export default App;
