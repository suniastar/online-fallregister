import React from 'react';
//import './App.css';
import './App_light.css';
import {FormLabel, Input, Grid} from '@material-ui/core/';

function App() {
    return (
        <div className="App">
            <header className="App-header">
                <form action="/action_page.php">
                <Grid
                      container
                      direction='column'
                      justify="center"
                      //alignItems='flex-start'

                      >
                    <Grid>
                        <h>Patientendaten</h>
                    </Grid>
                    <div style={{padding: 20}}>
                    <Grid container spacing={10}>
                    <FormLabel for="fname">Vorname:</FormLabel>
                    <Input type="text" id="fname" name="fname"></Input>
                    </Grid>
                    </div>
                    <Grid>
                    <FormLabel for="lname">Nachname:</FormLabel>
                    <Input type="text" id="lname" name="lname"></Input>
                    </Grid>
                    <Grid>
                    <FormLabel for="gender">Geschlecht:</FormLabel>
                 
                    <select id="gender" name="gender">
                    <option value="" disabled selected>Select your option</option>
                    <option value="male">Männlich</option>
                    <option value="female">Weiblich</option>
                    <option value="other">Sonstiges</option>
                    </select>
                    </Grid>
                    <Grid>
                    <FormLabel for="birthday">Geburtsdatum:</FormLabel>
                    <Input type="date" id="birthday" name="birthday"></Input>
                    </Grid>
                    <Grid>
                    <FormLabel for="address">Adresse:</FormLabel>
                    <Input type="text" id="address" name="address"></Input>
                    </Grid>
                    <Grid>                    
                    <FormLabel for="email">Email:</FormLabel>
                    <Input type="email" id="email" name="email"></Input>
                    </Grid>
                    <Grid>
                    <FormLabel for="telephonenumber">Telefonnummer:</FormLabel>
                    <Input type="tel" id="telephonenumber" name="telephonenumber"></Input>
                    </Grid>
                    <Grid>
                    <FormLabel for="activity">Tätigkeit:</FormLabel>
                    <Input type="text" id="activity" name="activity"></Input>
                    </Grid>
                    <Grid>
                    <FormLabel for="care">Betreuung:</FormLabel>
                    <Input type="text" id="care" name="care"></Input>
                    </Grid>
                    <Grid>
                    <FormLabel for="stay">Unterbringung:</FormLabel>
                    <Input type="text" id="stay" name="stay"></Input>
                    </Grid>
                    <Grid>
                    <FormLabel for="diagnose">Diagnose/Verdachtsdiagnose:</FormLabel>
                    <Input type="text" id="diagnose" name="diagnose"></Input>
                    </Grid>
                    <Grid>
                    <FormLabel for="stay">Unterbringung:</FormLabel>
                    <Input type="text" id="stay" name="stay"></Input>
                    </Grid>
                    <Grid>
                    <FormLabel for="dayOfInfection">Tag der Erkrankung:</FormLabel>
                    <Input type="date" id="dayOfInfection" name="dayOfInfection"></Input>
                    </Grid>
                    <Grid>
                    <FormLabel for="dayOfDiagnose">Tag der Diagnose:</FormLabel>
                    <Input type="date" id="dayOfDiagnose" name="dayOfDiagnose"></Input>
                    </Grid>
                    <Grid>
                    <FormLabel for="dayOfDeath">Tag des Todes:</FormLabel>
                    <Input type="date" id="dayOfDeath" name="dayOfDeath"></Input>
                    </Grid>
                    <Grid>
                    <FormLabel for="timeslotOfInfection">Zeitraum der Infektion:</FormLabel>
                    <Input type="date" id="timeslotOfInfection" name="timeslotOfInfection"></Input>
                    </Grid>
                    <Grid>
                    <FormLabel for="infectionSource">Infektionsquelle:</FormLabel>
                    <Input type="text" id="infectionSource" name="infectionSource"></Input>
                    </Grid>
                    <Grid>
                    <FormLabel for="infectionPlace">Infektionsort:</FormLabel>
                    <Input type="text" id="infectionPlace" name="infectionPlace"></Input>
                    </Grid>
                    <Grid>
                    <FormLabel for="transfer">Überweisung:</FormLabel>
                    <Input type="text" id="transfer" name="transfer"></Input>
                    </Grid>
                    <Grid>
                    <FormLabel for="admission">Aufnahme:</FormLabel>
                    <Input type="date" id="admission" name="admission"></Input>
                    </Grid>
                    <Grid>
                    <FormLabel for="dismissal">Entlassung:</FormLabel>
                    <Input type="date" id="dismissal" name="dismissal"></Input>
                    </Grid>
                    

                    <h>Labor</h>
                    
                    <Grid>
                    <FormLabel for="fname">First name:</FormLabel>
                    <Input type="text" id="fname" name="fname"></Input>
                    </Grid>
                    <Grid>
                    <FormLabel for="lname">Last name:</FormLabel>
                    <Input type="text" id="lname" name="lname"></Input>
                    </Grid>
                    <Grid>
                    <FormLabel for="telephonenumber">Telefonnummer:</FormLabel>
                    <Input type="tel" id="telephonenumber" name="telephonenumber"></Input>
                    </Grid>
                    <Grid>
                    <FormLabel for="email">Email:</FormLabel>
                    <Input type="date" id="email" name="email"></Input>
                    </Grid>
                    <Grid>
                    <FormLabel for="labor">Untersuchungsstelle:</FormLabel>
                    <Input type="text" id="labor" name="labor"></Input>
                    </Grid>

                    
                    <h>Melder</h>
                    <Grid>
                    <FormLabel for="fname">First name:</FormLabel>
                    <Input type="text" id="fname" name="fname"></Input>
                    </Grid>
                    <Grid>
                    <FormLabel for="lname">Last name:</FormLabel>
                    <Input type="text" id="lname" name="lname"></Input>
                    </Grid>
                    <Grid>
                    <FormLabel for="address">Anschrift:</FormLabel>
                    <Input type="text" id="address" name="address"></Input>
                    </Grid>
                    <Grid>
                    <FormLabel for="email">Email:</FormLabel>
                    <Input type="text" id="email" name="email"></Input>                    
                    </Grid>
                    <Grid>
                    <FormLabel for="telephonnumber">Telefonnummer:</FormLabel>
                    <Input type="tel" id="telephonnumber" name="telephonenumber"></Input>
                    </Grid>
                    <Input type="submit" value="Submit"></Input>
                    </Grid>
                </form>
            </header>
        </div>
    );
}

export default App;
