import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { SampleAngularRegionMySuffixModule } from './region/region-my-suffix.module';
import { SampleAngularCountryMySuffixModule } from './country/country-my-suffix.module';
import { SampleAngularLocationMySuffixModule } from './location/location-my-suffix.module';
import { SampleAngularDepartmentMySuffixModule } from './department/department-my-suffix.module';
import { SampleAngularTaskMySuffixModule } from './task/task-my-suffix.module';
import { SampleAngularEmployeeMySuffixModule } from './employee/employee-my-suffix.module';
import { SampleAngularJobMySuffixModule } from './job/job-my-suffix.module';
import { SampleAngularJobHistoryMySuffixModule } from './job-history/job-history-my-suffix.module';
/* jhipster-needle-add-entity-module-import - JHipster will add entity modules imports here */

@NgModule({
    imports: [
        SampleAngularRegionMySuffixModule,
        SampleAngularCountryMySuffixModule,
        SampleAngularLocationMySuffixModule,
        SampleAngularDepartmentMySuffixModule,
        SampleAngularTaskMySuffixModule,
        SampleAngularEmployeeMySuffixModule,
        SampleAngularJobMySuffixModule,
        SampleAngularJobHistoryMySuffixModule,
        /* jhipster-needle-add-entity-module - JHipster will add entity modules here */
    ],
    declarations: [],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class SampleAngularEntityModule {}
