
import React from 'react';

import {FormLabel, Input, Grid} from '@material-ui/core/';

class CVSImportForm extends React.Component {
    render(){

        return(
            <form action="/action_page.php">
            <Grid
        container
        direction='column'
        justify="center"
            //alignItems='flex-start'
            >

            <Grid>
            <h>CVS Import</h>
            </Grid>

            <Grid>
            <FormLabel for="lname">CVS Dokument hochladen: </FormLabel>
            <Input type="file" id="cvsFile" name="cvsFile"></Input>

            </Grid>

            <Input type="submit" value="Submit"></Input>
            </Grid>
            </form>
    );
    }
}

export default CVSImportForm;