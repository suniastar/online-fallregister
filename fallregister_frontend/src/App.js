import React from 'react';
//import './App.css';
import './App_light.css';
import {FormLabel, Input} from '@material-ui/core/';

function App() {
    return (
        <div className="App">
            <header className="App-header">
                <form action="/action_page.php">

                    <h>Patientendaten</h>
                    <br></br>
                    <FormLabel for="fname">Vorname:</FormLabel>
                    <br></br><Input type="text" id="fname" name="fname"></Input>
                    <br></br>
                    <FormLabel for="lname">Nachname:</FormLabel>
                    <br></br><Input type="text" id="lname" name="lname"></Input>
                    <br></br>
                    <FormLabel htmlFor="gender">Geschlecht:</FormLabel>
                    <br></br>
                    <select id="gender" name="gender">
                    <option value="" disabled selected>Select your option</option>
                    <option value="male">Männlich</option>
                    <option value="female">Weiblich</option>
                    <option value="other">Sonstiges</option>
                    </select><br></br>
                    <FormLabel for="birthday">Geburtsdatum:</FormLabel>
                    <br></br><Input type="text" id="birthday" name="birthday"></Input>
                    <br></br>
                    <FormLabel htmlFor="address">Adresse:</FormLabel>
                    <br></br><Input type="text" id="address" name="address"></Input>
                    <br></br>
                    <FormLabel htmlFor="email">Email:</FormLabel>
                    <br></br><Input type="text" id="email" name="email"></Input>
                    <br></br>
                    <FormLabel htmlFor="telephonenumber">Telefonnummer:</FormLabel>
                    <br></br><Input type="text" id="telephonenumber" name="telephonenumber"></Input>
                    <br></br>
                    <FormLabel htmlFor="activity">Tätigkeit:</FormLabel>
                    <br></br><Input type="text" id="activity" name="activity"></Input>
                    <br></br>
                    <FormLabel htmlFor="care">Betreuung:</FormLabel>
                    <br></br><Input type="text" id="care" name="care"></Input>
                    <br></br>
                    <FormLabel htmlFor="stay">Unterbringung:</FormLabel>
                    <br></br><Input type="text" id="stay" name="stay"></Input>
                    <br></br>
                    <FormLabel htmlFor="diagnose">Diagnose/Verdachtsdiagnose:</FormLabel>
                    <br></br><Input type="text" id="diagnose" name="diagnose"></Input>
                    <br></br>
                    <FormLabel htmlFor="stay">Unterbringung:</FormLabel>
                    <br></br><Input type="text" id="stay" name="stay"></Input>
                    <br></br>
                    <FormLabel htmlFor="dayOfInfection">Tag der Erkrankung:</FormLabel>
                    <br></br><Input type="text" id="dayOfInfection" name="dayOfInfection"></Input>
                    <br></br>
                    <FormLabel htmlFor="dayOfDiagnose">Tag der Diagnose:</FormLabel>
                    <br></br><Input type="text" id="dayOfDiagnose" name="dayOfDiagnose"></Input>
                    <br></br>
                    <FormLabel htmlFor="dayOfDeath">Tag des Todes:</FormLabel>
                    <br></br><Input type="text" id="dayOfDeath" name="dayOfDeath"></Input>
                    <br></br>
                    <FormLabel htmlFor="timeslotOfInfection">Zeitraum der Infektion:</FormLabel>
                    <br></br><Input type="text" id="timeslotOfInfection" name="timeslotOfInfection"></Input>
                    <br></br>
                    <FormLabel htmlFor="infectionSource">Infektionsquelle:</FormLabel>
                    <br></br><Input type="text" id="infectionSource" name="infectionSource"></Input>
                    <br></br>
                    <FormLabel htmlFor="infectionPlace">Infektionsort:</FormLabel>
                    <br></br><Input type="text" id="infectionPlace" name="infectionPlace"></Input>
                    <br></br>
                    <FormLabel htmlFor="transfer">Überweisung:</FormLabel>
                    <br></br><Input type="text" id="transfer" name="transfer"></Input>
                    <br></br>
                    <FormLabel htmlFor="admission">Aufnahme:</FormLabel>
                    <br></br><Input type="text" id="admission" name="admission"></Input>
                    <br></br>
                    <FormLabel htmlFor="dismissal">Entlassung:</FormLabel>
                    <br></br><Input type="text" id="dismissal" name="dismissal"></Input>
                    <br></br>
                    <br></br>

                    <h>Labor</h>
                    <br></br>
                    <FormLabel for="fname">First name:</FormLabel>
                    <br></br><Input type="text" id="fname" name="fname"></Input>
                    <br></br>
                    <FormLabel for="lname">Last name:</FormLabel>
                    <br></br><Input type="text" id="lname" name="lname"></Input>
                    <br></br>
                    <FormLabel for="birthday">Telefonnummer:</FormLabel>
                    <br></br><Input type="text" id="telephonenumber" name="telephonenumber"></Input>
                    <br></br>
                    <FormLabel htmlFor="birthday">Email:</FormLabel>
                    <br></br><Input type="text" id="email" name="email"></Input>
                    <br></br>
                    <FormLabel htmlFor="birthday">Untersuchungsstelle:</FormLabel>
                    <br></br><Input type="text" id="labor" name="labor"></Input>
                    <br></br>

                    <br></br>
                    <h>Melder</h>
                    <br></br>
                    <FormLabel htmlFor="fname">First name:</FormLabel>
                    <br></br><Input type="text" id="fname" name="fname"></Input>
                    <br></br>
                    <FormLabel htmlFor="lname">Last name:</FormLabel>
                    <br></br><Input type="text" id="lname" name="lname"></Input>
                    <br></br>
                    <FormLabel htmlFor="birthday">Anschrift:</FormLabel>
                    <br></br><Input type="text" id="address" name="address"></Input>
                    <br></br>
                    <FormLabel htmlFor="birthday">Email:</FormLabel>
                    <br></br><Input type="text" id="email" name="email"></Input>
                    <br></br>
                    <FormLabel htmlFor="birthday">Telefonnummer:</FormLabel>
                    <br></br><Input type="text" id="telephonnumber" name="telephonenumber"></Input>
                    <br></br>

                    <br></br><Input type="submit" value="Submit"></Input>
                    <br></br><br></br>
                </form>
            </header>
        </div>
    );
}

export default App;
