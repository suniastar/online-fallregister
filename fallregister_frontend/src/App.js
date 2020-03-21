import React from 'react';
//import './App.css';
import './App_light.css';
import {FormLabel, Input, Grid} from '@material-ui/core/';

function App() {
    return (
        <div className="App">
            <header className="App-header">
                <form action="/action_page.php">

                    <h>Patientendaten</h>
                    
                    <Grid
                      container
                      direction='column'
                      justify="center"
                      //alignItems='center'
                      >
                    <Grid>
                    <FormLabel for="fname">Vorname:</FormLabel>
                    <Input type="text" id="fname" name="fname"></Input>
                    </Grid>
                    <Grid>
                    <FormLabel for="lname">Nachname:</FormLabel>
                    <Input type="text" id="lname" name="lname"></Input>
                    </Grid>
                    <Grid>
                    <FormLabel htmlFor="gender">Geschlecht:</FormLabel>
                 
                    <select id="gender" name="gender">
                    <option value="" disabled selected>Select your option</option>
                    <option value="male">Männlich</option>
                    <option value="female">Weiblich</option>
                    <option value="other">Sonstiges</option>
                    </select>
                    </Grid>
                    <Grid>
                    <FormLabel for="birthday">Geburtsdatum:</FormLabel>
                    <Input type="text" id="birthday" name="birthday"></Input>
                    </Grid>
                    <Grid>
                    <FormLabel htmlFor="address">Adresse:</FormLabel>
                    <Input type="text" id="address" name="address"></Input>
                    </Grid>
                    <Grid>                    
                    <FormLabel htmlFor="email">Email:</FormLabel>
                    <Input type="text" id="email" name="email"></Input>
                    </Grid>
                    <Grid>
                    <FormLabel htmlFor="telephonenumber">Telefonnummer:</FormLabel>
                    <Input type="text" id="telephonenumber" name="telephonenumber"></Input>
                    </Grid>
                    <Grid>
                    <FormLabel htmlFor="activity">Tätigkeit:</FormLabel>
                    <Input type="text" id="activity" name="activity"></Input>
                    </Grid>
                    <Grid>
                    <FormLabel htmlFor="care">Betreuung:</FormLabel>
                    <Input type="text" id="care" name="care"></Input>
                    </Grid>
                    <Grid>
                    <FormLabel htmlFor="stay">Unterbringung:</FormLabel>
                    <Input type="text" id="stay" name="stay"></Input>
                    </Grid>
                    <Grid>
                    <FormLabel htmlFor="diagnose">Diagnose/Verdachtsdiagnose:</FormLabel>
                    <Input type="text" id="diagnose" name="diagnose"></Input>
                    </Grid>
                    <Grid>
                    <FormLabel htmlFor="stay">Unterbringung:</FormLabel>
                    <Input type="text" id="stay" name="stay"></Input>
                    </Grid>
                    <Grid>
                    <FormLabel htmlFor="dayOfInfection">Tag der Erkrankung:</FormLabel>
                    <Input type="text" id="dayOfInfection" name="dayOfInfection"></Input>
                    </Grid>
                    <Grid>
                    <FormLabel htmlFor="dayOfDiagnose">Tag der Diagnose:</FormLabel>
                    <Input type="text" id="dayOfDiagnose" name="dayOfDiagnose"></Input>
                    </Grid>
                    <Grid>
                    <FormLabel htmlFor="dayOfDeath">Tag des Todes:</FormLabel>
                    <Input type="text" id="dayOfDeath" name="dayOfDeath"></Input>
                    </Grid>
                    <Grid>
                    <FormLabel htmlFor="timeslotOfInfection">Zeitraum der Infektion:</FormLabel>
                    <Input type="text" id="timeslotOfInfection" name="timeslotOfInfection"></Input>
                    </Grid>
                    <Grid>
                    <FormLabel htmlFor="infectionSource">Infektionsquelle:</FormLabel>
                    <Input type="text" id="infectionSource" name="infectionSource"></Input>
                    </Grid>
                    <Grid>
                    <FormLabel htmlFor="infectionPlace">Infektionsort:</FormLabel>
                    <Input type="text" id="infectionPlace" name="infectionPlace"></Input>
                    </Grid>
                    <Grid>
                    <FormLabel htmlFor="transfer">Überweisung:</FormLabel>
                    <Input type="text" id="transfer" name="transfer"></Input>
                    </Grid>
                    <Grid>
                    <FormLabel htmlFor="admission">Aufnahme:</FormLabel>
                    <Input type="text" id="admission" name="admission"></Input>
                    </Grid>
                    <Grid>
                    <FormLabel htmlFor="dismissal">Entlassung:</FormLabel>
                    <Input type="text" id="dismissal" name="dismissal"></Input>
                    </Grid>
                    

                    <h>Labor</h>
                    
                    <FormLabel for="fname">First name:</FormLabel>
                    <Input type="text" id="fname" name="fname"></Input>
                    
                    <FormLabel for="lname">Last name:</FormLabel>
                    <Input type="text" id="lname" name="lname"></Input>
                    
                    <FormLabel for="birthday">Telefonnummer:</FormLabel>
                    <Input type="text" id="telephonenumber" name="telephonenumber"></Input>
                    
                    <FormLabel htmlFor="birthday">Email:</FormLabel>
                    <Input type="text" id="email" name="email"></Input>
                    
                    <FormLabel htmlFor="birthday">Untersuchungsstelle:</FormLabel>
                    <Input type="text" id="labor" name="labor"></Input>
                    

                    
                    <h>Melder</h>
                    
                    <FormLabel htmlFor="fname">First name:</FormLabel>
                    <Input type="text" id="fname" name="fname"></Input>
                    
                    <FormLabel htmlFor="lname">Last name:</FormLabel>
                    <Input type="text" id="lname" name="lname"></Input>
                    
                    <FormLabel htmlFor="birthday">Anschrift:</FormLabel>
                    <Input type="text" id="address" name="address"></Input>
                    <FormLabel htmlFor="birthday">Email:</FormLabel>
                    <Input type="text" id="email" name="email"></Input>                    
                    <FormLabel htmlFor="birthday">Telefonnummer:</FormLabel>
                    <Input type="text" id="telephonnumber" name="telephonenumber"></Input>
                    <Input type="submit" value="Submit"></Input>
                    </Grid>
                </form>
            </header>
        </div>
    );
}

export default App;
