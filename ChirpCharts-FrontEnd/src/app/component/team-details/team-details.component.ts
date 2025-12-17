import { Component } from '@angular/core';
import { Team } from '../../common/team';
import { TeamService } from '../../services/team.service';
import { ChirpChatService } from '../../services/chirp-chat.service';
import { ActivatedRoute } from '@angular/router';
import { Chat } from '../../common/chat';

@Component({
  selector: 'app-team-details',
  templateUrl: './team-details.component.html',
  styleUrl: './team-details.component.css'
})
export class TeamDetailsComponent {
  teams: Team[] = [];
  messages: Chat[] = [];
  newMessage = '';
  franchiseId: number = 1;
  year = 20242025
  editingMessageId: number | null = null;
  editedMessage: string = '';


  constructor(private teamService: TeamService, 
    private chirpChatService: ChirpChatService,
    private route: ActivatedRoute) { }

    ngOnInit(): void {
    this.route.paramMap.subscribe(() => {
      this.listDetails();
      });

    

}
listDetails() {
  const hasFranchiseId: boolean = this.route.snapshot.paramMap.has("franchiseId");
  const hasYear: boolean = this.route.snapshot.paramMap.has("year");

  if (hasFranchiseId && hasYear) {
    this.franchiseId = +this.route.snapshot.paramMap.get("franchiseId")!;
    this.year = +this.route.snapshot.paramMap.get("year")!;
  } else {
    this.franchiseId = 1
    this.year = 20002001
  }
  this.teamService.getTeamDetails(this.franchiseId,this.year).subscribe(
    data => {
      this.teams = data;
    }
  )
  this.chirpChatService.getChirpChatForTeam(this.franchiseId,this.year).subscribe(
    data => {
      this.messages = data
    }
  )
}

deleteChirp(theChatId: number) {
  this.chirpChatService.deleteChirp(theChatId).subscribe(() => {
    this.listDetails();
  })
}

addNewChirp() {
  const chat: Chat = {
    message: this.newMessage,
    franchiseId: this.franchiseId,
    year: this.year
  }
  this.chirpChatService.createNewChirpChat(chat).subscribe(() => {
    this.listDetails();
    this.newMessage = ''
  })
}

startEdit(message: Chat) {
  this.editingMessageId = message.id!;
  this.editedMessage = message.message!;
}

cancelEdit() {
  this.editingMessageId = null;
  this.editedMessage = '';
}

updateChirp(chatId: number) {
  if (!this.editedMessage.trim()) {
    return;
  }

  const updatedChat: Chat = {
    id: chatId,
    message: this.editedMessage,
    franchiseId: this.franchiseId,
    year: this.year
  };
  this.chirpChatService.updateChirpChat(chatId, updatedChat).subscribe(() => {
    this.listDetails();
    this.cancelEdit();
  })
}


}
