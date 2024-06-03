import { Component, input } from '@angular/core';
import { RouterModule } from '@angular/router';

import SharedModule from 'app/shared/shared.module';
import { DurationPipe, FormatMediumDatetimePipe, FormatMediumDatePipe } from 'app/shared/date';
import { IOrganizationDomain } from '../organization-domain.model';

@Component({
  standalone: true,
  selector: 'jhi-organization-domain-detail',
  templateUrl: './organization-domain-detail.component.html',
  imports: [SharedModule, RouterModule, DurationPipe, FormatMediumDatetimePipe, FormatMediumDatePipe],
})
export class OrganizationDomainDetailComponent {
  organizationDomain = input<IOrganizationDomain | null>(null);

  previousState(): void {
    window.history.back();
  }
}
