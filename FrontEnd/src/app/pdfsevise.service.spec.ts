import { TestBed } from '@angular/core/testing';

import { PdfseviseService } from './pdfsevise.service';

describe('PdfseviseService', () => {
  let service: PdfseviseService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PdfseviseService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
