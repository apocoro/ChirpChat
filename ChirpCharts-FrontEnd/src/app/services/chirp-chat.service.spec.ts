import { TestBed } from '@angular/core/testing';

import { ChirpChatService } from './chirp-chat.service';

describe('ChirpChatService', () => {
  let service: ChirpChatService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ChirpChatService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
