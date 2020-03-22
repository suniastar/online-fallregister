
import React from 'react';

import { FormLabel, FormControlLabel, Input, Grid, Checkbox, Button} from '@material-ui/core/';

class PatientDataForm extends React.Component {
    constructor() {
        super();
        this.onSubmit = this.onSubmit.bind(this);
    }

    onSubmit(event) {
        event.preventDefault();
        let sex = document.getElementById("sexMale").checked ? "male" : "";
        sex = document.getElementById("sexFemale").checked ? "female" : sex;
        sex = document.getElementById("sexDivers").checked ? "divers" : sex;
        const json = {
            patientFirstName: document.getElementById("patientFirstName").value,
            patientLastName: document.getElementById("patientLastName").value,
            patientAddressStreet : document.getElementById("patientStreet").value,
            patientAddressHousenumber: document.getElementById("patientHouse").value,
            patientAddressZipcode: document.getElementById("patientZip").value,
            patientAddressCity:document.getElementById("patientCity").value,
            patientAddressCountry:document.getElementById("patientCountry").value,
            patientBirthday: document.getElementById("patientBirthday").value,
            patientSex: sex,
            patientPhone: document.getElementById("patientPhone").value,
            patientEmail: document.getElementById("patientEmail").value,
            detectorFirstName: document.getElementById("mFname").value,
            detectorLastName: document.getElementById("mName").value,
            detectorAddressStreet: document.getElementById("mStreet").value,
            detectorAddressHousenumber: document.getElementById("mHousenumber").value,
            detectorAddressZipcode: document.getElementById("mZip").value,
            detectorAddressCity:document.getElementById("mCity").value,
            detectorPhone: document.getElementById("mPhone").value,
            detectorEmail: document.getElementById("mMail").value,
            diagnosisName: "COVID19",
            diagnosisSuspected: document.getElementById("suspected").checked,
            diagnosisDiagnosed: document.getElementById("diagnosed").checked,
            diagnosisDead: document.getElementById("death").checked,
            diagnosisDateOfSickness: document.getElementById("dayOfInfection").value,
            diagnosisDateOfDiagnosis: document.getElementById("dayOfDiagnose").value,
            diagnosisDateOfDeath: document.getElementById("dayOfDeath").value,
            jobsMedical: document.getElementById("medical").checked,
            jobsFood: document.getElementById("food").checked,
            jobsCommunal: document.getElementById("epiCommunal").checked,
            infectionPlace: document.getElementById("infectionPlace").value,
            infectionSource:  document.getElementById("infectionPlace").value,
            infectionEpidemi:  document.getElementById("epidemi").checked,
            infectionEpidemiSource: document.getElementById("infectionExposition").value,
            accommodationCommunal:document.getElementById("accCommunal").checked,
            accommodationHospital: document.getElementById("hospital").checked,
            accommodationDateOfHospitalisation: document.getElementById("dateOfHospitalisation").value,
            accommodationIcu: document.getElementById("patientFirstName").checked,
            accommodationDateOfIcu: document.getElementById("patientFirstName").value,
            accommodationNameAndAddress: document.getElementById("addressAndPlace").value,
            gesundheitsamtName: document.getElementById("gName").value,
            gesundheitsamtAddressStreet : document.getElementById("gStreet").value,
            gesundheitsamtAddressHousenumber: document.getElementById("gHousenumber").value,
            gesundheitsamtAddressZipcode: document.getElementById("gZip").value,
            gesundheitsamtAddressCity:document.getElementById("gCity").value,
            gesundheitsPhone: document.getElementById("gPhone").value,
            gesundheitsEmail: document.getElementById("gMail").value,
            gesundheitsUntersuchungsstelle: document.getElementById("gStelle").value,
            laboratoryCommission: document.getElementById("commission").checked,
            laboratoryName: document.getElementById("labname").value,
            laboratoryLocation: document.getElementById("lablocation").value,
            laboratoryPhone: document.getElementById("labphone").value,
            laboratoryDateOfBiopsy: document.getElementById("probedate").value
        }
        fetch('http://localhost:8080/infected', {
         method: 'POST',
         headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(json)
        })
        .then(res => res.json())
        .then(
          (result) => {
              if(result.status === "201"){
                alert("Erfolgreich gespeichert")
              }else{
                  alert(result.status)
              }

          },
          // Note: it's important to handle errors here
          // instead of a catch() block so that we don't swallow
          // exceptions from actual bugs in components.
          (error) => {
            alert("fehler" + error)
          }
        )
    }

    render() {

        return (
            <form onSubmit={this.onSubmit}>
                <Grid
                    container
                    direction='column'
                    justify="center"
                    alignItems='stretch'

                >
                    <Grid>
                        <Grid container
                              direction='row'
                              justify='space-between'
                        >
                            <Grid>
                                <FormLabel class="big">Meldeformular</FormLabel>
                            </Grid>
                            <Grid>
                                -Vertraulich-
                            </Grid>
                        </Grid>
                        <FormLabel class="big">Meldepflichtige Krankheit gemäß §§6,8,9 IfSG (Spezialfall
                            Corona)</FormLabel>
                    </Grid>

                    <div class="horizontalDivider"></div>
                    <Grid container
                          direction='row'
                          justify='flex-start'
                          alignItems="stretch"
                    >
                        <Grid container
                              direction='row'
                              justify='flex-start'
                              alignItems="stretch"
                        >

                            <Grid container
                                  direction='column'
                                  item
                                  xs={6}
                            >
                                <Grid>
                                    <FormLabel class="big">Patientendaten </FormLabel>
                                </Grid>
                                <Grid direction="column" container>
                                    <Grid direction="row" container>
                                        <Grid container
                                              direction='column'
                                              xs={6}
                                              item>

                                            <Grid direction="column" container>
                                                <Grid>
                                                    <FormLabel htmlFor="fname">Vorname: </FormLabel>
                                                </Grid>
                                                <Grid>
                                                    <Input required type="text" id="patientFirstName" name="fname"
                                                           ref="myFirstname"></Input>
                                                </Grid>
                                            </Grid>

                                            <Grid direction="column" container>
                                                <Grid>
                                                    <FormLabel htmlFor="address">Strasse: </FormLabel>
                                                </Grid>
                                            </Grid>
                                            <Grid>
                                                <Input type="text" id="patientStreet" name="address"></Input>
                                            </Grid>
                                            <Grid direction="column" container>
                                                <Grid>
                                                    <FormLabel htmlFor="address">PLZ: </FormLabel>
                                                </Grid>
                                                <Grid>
                                                    <Input type="text" id="patientZip" name="address"></Input>
                                                </Grid>
                                            </Grid>
                                            <Grid direction="column" container>
                                                <Grid>
                                                    <FormLabel htmlFor="address">Land: </FormLabel>
                                                </Grid>
                                            </Grid>
                                            <Grid>
                                                <Input type="text" id="patientCountry" name="address"></Input>
                                            </Grid>
                                        </Grid>
                                        <Grid container
                                              direction='column'
                                              item
                                              xs={6}>
                                            <Grid direction="column" container>
                                                <Grid>
                                                    <FormLabel htmlFor="lname">Nachname: </FormLabel>
                                                </Grid>
                                                <Grid>
                                                    <Input required type="text" id="patientLastName"
                                                           name="lname"></Input>
                                                </Grid>
                                            </Grid>
                                            <Grid direction="column" container>
                                                <Grid>
                                                    <FormLabel htmlFor="address">Hausnummer: </FormLabel>
                                                </Grid>
                                                <Grid>
                                                    <Input type="text" id="patientHouse" name="address"></Input>
                                                </Grid>
                                            </Grid>
                                            <Grid direction="column" container>
                                                <Grid>
                                                    <FormLabel htmlFor="address">Stadt: </FormLabel>
                                                </Grid>
                                                <Grid>
                                                    <Input type="text" id="patientCity" name="address"></Input>
                                                </Grid>
                                            </Grid>
                                        </Grid>
                                    </Grid>
                                    <Grid direction="column" container>
                                        <Grid>
                                            <FormLabel htmlFor="birthday">Geburtsdatum: </FormLabel>
                                        </Grid>
                                        <Grid>
                                            <Input required type="date" id="patientBirthday" name="birthday"></Input>
                                        </Grid>

                                        <Grid>
                                            <FormLabel htmlFor="gender">Geschlecht: </FormLabel>
                                            <FormControlLabel control={<Checkbox id="sexFemale"/>} label="weiblich"/>
                                            <FormControlLabel control={<Checkbox id="sexMale"/>} label="männlich"/>
                                            <FormControlLabel control={<Checkbox id="sexDivers"/>} label="divers"/>
                                        </Grid>

                                        <Grid>
                                            <FormLabel htmlFor="telephonenumber">Telefonnummer: </FormLabel>
                                        </Grid>
                                        <Grid>
                                            <Input type="tel" id="patientPhone" name="telephonenumber"></Input>
                                        </Grid>

                                        <Grid>
                                            <FormLabel htmlFor="email">Email: </FormLabel>
                                        </Grid>
                                        <Grid>
                                            <Input type="email" id="patientEmail" name="email"></Input>
                                        </Grid>
                                    </Grid>
                                </Grid>
                            </Grid>
                            <div class="verticalDivider"></div>
                            <Grid container
                                  direction='column'
                                  xs={5}
                                  item
                            >
                                <Grid>
                                    <FormControlLabel control={<Checkbox id="suspected"/>} label="Verdacht"/>
                                </Grid>
                                <Grid>
                                    <FormControlLabel control={<Checkbox id="diagnosed"/>}
                                                      label="Klinische Diagnose"/>
                                </Grid>
                                <Grid>
                                    <FormControlLabel control={<Checkbox id="death"/>} label="Tod"/>
                                </Grid>
                                <Grid>
                                    <FormLabel htmlFor="fname">Todesdatum: </FormLabel>
                                </Grid>
                                <Grid>
                                    <Input type="date" id="dayOfDeath" name="dayOfDeath"></Input>
                                </Grid>
                                <Grid>
                                    <FormLabel htmlFor="dayOfInfection">Erkrankungsbeginn: </FormLabel>
                                </Grid>
                                <Grid>
                                    <Input type="date" id="dayOfInfection" name="dayOfInfection"></Input>
                                </Grid>
                                <Grid>
                                    <FormLabel htmlFor="dayOfDiagnose">Diagnosedatum: </FormLabel>
                                </Grid>
                                <Grid>
                                    <Input type="date" id="dayOfDiagnose" name="dayOfDiagnose"></Input>
                                </Grid>
                            </Grid>

                        </Grid>

                        <div class="horizontalDivider"></div>
                        <Grid container
                              direction='row'
                              justify='flex-start'
                              alignItems="stretch"
                              item
                        >
                            <Grid container
                                  direction='column'
                                  justify='flex-start'
                                  alignItems="stretch"
                                  xs={9}
                                  item
                            >
                                <Grid>
                                    <FormLabel class="big">Epidemiologische Situation: </FormLabel>
                                </Grid>
                                <Grid>
                                    <FormControlLabel control={<Checkbox id="medical"/>}
                                                      label="Patient/in ist im medizinischen Bereich taetig"/>
                                </Grid>
                                <Grid>
                                    <FormControlLabel control={<Checkbox id="food"/>}
                                                      label="Patient/in ist im Lebensmittelbereich taetig"/>
                                </Grid>
                                <Grid>
                                    <FormControlLabel control={<Checkbox id="epiCommunal"/>}
                                                      label="Patient/in ist in Gemeinschaftseinrichtung taetig,  z.B. Schule, Kinderkrippe, Heim, sonst. Massenunterkuenfte"/>
                                </Grid>

                                <Grid>
                                    <FormControlLabel control={<Checkbox id="accCommunal"/>}
                                                      label="Patient/in wird in Gemeinschaftseinrichtung betreut, z.B. Schule, Kinderkrippe, Heim, sonst. Massenunterkuenfte"/>
                                </Grid>
                                <Grid>
                                    <FormControlLabel control={<Checkbox id="hospital"/>}
                                                      label="Patient/in ist in Krankenhaus/Pflegeeinrichtung seit: "/>
                                    <Input type="date" id="dateOfcare" name="dateOfcare"
                                           id="dateOfHospitalisation"></Input>
                                </Grid>
                                <Grid>
                                    <FormControlLabel control={<Checkbox id="intensiveCare"/>}
                                                      label="Patient/in ist auf der Intensivstation seit: "/>
                                    <Input type="date" id="dateOfIntensiveCare"></Input>
                                </Grid>
                                <Grid>
                                    <FormLabel htmlFor="stay">Name und Ort der Einrichtung: </FormLabel>
                                    <Input type="text" id="stay" name="stay" id="addressAndPlace"></Input>
                                </Grid>
                            </Grid>

                        </Grid>
                        <div className="horizontalDivider"></div>
                        <Grid container
                              direction='column'
                              justify='flex-start'
                              alignItems="stretch"

                        >
                            <Grid>
                                <FormLabel class="big">Angaben zur wahrscheinlichen Infektionsquelle: </FormLabel>
                            </Grid>
                            <Grid>
                                <FormLabel htmlFor="infectionPlace">Wahrscheinlicher Infektionsort: </FormLabel>
                            </Grid>
                            <Grid>
                                <Input type="text" id="infectionPlace" name="infectionPlace"></Input>
                            </Grid>
                            <Grid>
                                <FormLabel htmlFor="infectionSource">Wahrscheinlicher Infektionsquelle: </FormLabel>
                            </Grid>
                            <Grid>
                                <Input type="text" id="infectionSource" name="infectionSource"></Input>
                            </Grid>
                            <Grid>
                                <FormControlLabel control={<Checkbox id="epidemi"/>}
                                                  label="Meldung ist Teil einer Erkrankungshäufung:"/>
                                <FormLabel htmlFor="infectionSource"> Ausbruchsort, vermutete Exposition,
                                    etc.: </FormLabel>
                                <Input type="text" id="infectionExposition" name="epidemiSource"></Input>
                            </Grid>
                        </Grid>
                        <div class="horizontalDivider"></div>
                        <Grid container
                              direction='row'
                              justify='flex-start'
                              alignItems="stretch"
                        >
                            <Grid container
                                  direction='column'
                                  justify='flex-start'
                                  alignItems="stretch"
                                  xs={4}
                                  item
                            >
                                <Grid>
                                    <FormLabel class="big">Unverzueglich zu melden an: </FormLabel>
                                </Grid>
                                <Grid>
                                    <FormLabel htmlFor="fname">Gesundheitsamt: </FormLabel>
                                </Grid>
                                <Grid>
                                    <Input required type="text" id="gName" name="fname"></Input>
                                </Grid>
                                <Grid>
                                    <FormLabel htmlFor="address">Strasse: </FormLabel>
                                </Grid>
                                <Grid>
                                    <Input type="text" id="gStreet" name="address"></Input>
                                </Grid>
                                <Grid>
                                    <FormLabel htmlFor="address">Hausnummer: </FormLabel>
                                </Grid>
                                <Grid>
                                    <Input type="text" id="gHousenumber" name="address"></Input>
                                </Grid>
                                <Grid>
                                    <FormLabel htmlFor="address">PLZ: </FormLabel>
                                </Grid>
                                <Grid>
                                    <Input type="text" id="gZip" name="address"></Input>
                                </Grid>
                                <Grid>
                                    <FormLabel htmlFor="address">Stadt: </FormLabel>
                                </Grid>
                                <Grid>
                                    <Input type="text" id="gCity" name="address"></Input>
                                </Grid>
                                <Grid>
                                    <FormLabel htmlFor="telephonenumber">Telefonnummer: </FormLabel>
                                </Grid>
                                <Grid>
                                    <Input type="tel" id="gPhone" name="telephonenumber"></Input>
                                </Grid>
                                <Grid>
                                    <FormLabel htmlFor="email">Email: </FormLabel>
                                </Grid>
                                <Grid>
                                    <Input type="email" id="gMail" name="email"></Input>
                                </Grid>
                                <Grid>
                                    <FormLabel htmlFor="labor">Untersuchungsstelle: </FormLabel>
                                </Grid>
                                <Grid>
                                    <Input type="text" id="gStelle" name="labor"></Input>
                                </Grid>
                            </Grid>
                            <div class="verticalDivider"></div>
                            <Grid container
                                  direction='column'
                                  xs={4}
                                  item
                            >
                                <Grid>
                                    <FormControlLabel control={<Checkbox id="commission"/>}
                                                      label="Es wurde ein Labor/eine Untersuchungsstelle mit der Erregerdiagnostik beauftragt."/>
                                </Grid>
                                <Grid>
                                    <FormLabel htmlFor="labname"> Labor Name: </FormLabel>
                                </Grid>
                                <Grid>
                                    <Input type="text" id="labname" name="labname"></Input>
                                </Grid>
                                <Grid>
                                    <FormLabel htmlFor="lablocation"> Labor Ort: </FormLabel>
                                </Grid>
                                <Grid>
                                    <Input type="text" id="lablocation" name="lablocation"></Input>
                                </Grid>
                                <Grid>
                                    <FormLabel htmlFor="labphone"> Labor Telefonnummer: </FormLabel>
                                </Grid>
                                <Grid>
                                    <Input type="text" id="labphone" name="labphone"></Input>
                                </Grid>
                                <Grid>
                                    <FormLabel htmlFor="probedate"> Probenentnahme am: </FormLabel>
                                </Grid>
                                <Grid>
                                    <Input type="text" id="probedate" name="probedate"></Input>
                                </Grid>
                            </Grid>
                            <div class="verticalDivider"></div>
                            <Grid container
                                  direction='column'
                                  justify='flex-start'
                                  alignItems="stretch"
                                  xs={3}
                                  item
                            >
                                <Grid>
                                    <FormLabel class="big">Melder</FormLabel>
                                </Grid>
                                <Grid>
                                    <FormLabel htmlFor="fname">Vorname: </FormLabel>
                                </Grid>
                                <Grid>
                                    <Input type="text" id="mFname" name="fname"></Input>
                                </Grid>
                                <Grid>
                                    <FormLabel htmlFor="lname">Nachname: </FormLabel>
                                </Grid>
                                <Grid>
                                    <Input type="text" id="mName" name="lname"></Input>
                                </Grid>
                                <Grid>
                                    <FormLabel htmlFor="address">Strasse: </FormLabel>
                                </Grid>
                                <Grid>
                                    <Input type="text" id="mStreet" name="address"></Input>
                                </Grid>
                                <Grid>
                                    <FormLabel htmlFor="address">Hausnummer: </FormLabel>
                                </Grid>
                                <Grid>
                                    <Input type="text" id="mHousenumber" name="address"></Input>
                                </Grid>
                                <Grid>
                                    <FormLabel htmlFor="address">PLZ: </FormLabel>
                                </Grid>
                                <Grid>
                                    <Input type="text" id="mZip" name="address"></Input>
                                </Grid>
                                <Grid>
                                    <FormLabel htmlFor="address">Stadt: </FormLabel>
                                </Grid>
                                <Grid>
                                    <Input type="text" id="mCity" name="address"></Input>
                                </Grid>
                                <Grid>
                                    <FormLabel htmlFor="email">Email: </FormLabel>
                                </Grid>
                                <Grid>
                                    <Input type="email" id="mMail" name="email"></Input>
                                </Grid>
                                <Grid>
                                    <FormLabel htmlFor="telephonenumber">Telefonnummer: </FormLabel>
                                </Grid>
                                <Grid>
                                    <Input type="tel" id="mPhone" name="telephonenumber"></Input>
                                </Grid>
                            </Grid>
                        </Grid>
                        <div class="horizontalDivider"></div>

                        <div class="submitButton">
                            <Button type="submit" value="Submit" variant="contained" color="primary">Daten
                                einreichen</Button>
                        </div>

                    </Grid>
                </Grid>
            </form>
        );
    }
}

export default PatientDataForm;