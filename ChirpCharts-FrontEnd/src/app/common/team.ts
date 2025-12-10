export class Team {

    constructor(
        public id: number,
        public franchiseId: number,
        public teamName: string,
        public year: string,
        public wins: number,
        public losses: number,
        public overTimeWins: number,
        public lastUpdated: Date

    ) {}

}
