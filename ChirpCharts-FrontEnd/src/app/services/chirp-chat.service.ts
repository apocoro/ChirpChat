import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Chat } from '../common/chat';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class ChirpChatService {

  private baseUrl = "https://back-end-java-springboot-chirpcharts-production.up.railway.app/api/chirpChat"

  constructor(private httpClient: HttpClient) { }

  getChirpChatForTeam(theFranchiseId: number, theYear:number): Observable<Chat[]> {
    const searchUrl = `${this.baseUrl}/chat-logs?franchiseId=${theFranchiseId}&year=${theYear}`
    return this.httpClient.get<Chat[]>(searchUrl)
  }
  
  createNewChirpChat(message: Chat){
    return this.httpClient.post<Chat>(this.baseUrl, message)
  }

  updateChirpChat(theChatId: number, message: Chat) {
    return this.httpClient.put<Chat>(`${this.baseUrl}/${theChatId}`, message)
  }

  deleteChirp(theChatId: number) {
    return this.httpClient.delete(`${this.baseUrl}/${theChatId}`)
  }
}
