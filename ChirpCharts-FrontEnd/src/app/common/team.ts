export class Team {

    constructor(
        public id: number,
        public franchiseId: number,
        public teamName: string,
        public year: number,
        public wins: number,
        public losses: number,
        public overTimeLosses: number,
        public lastUpdated: Date

    ) {}

    getDetailsHeading() {
        return this.teamName + "  " + this.year.toString().slice(2,4) + "-" + this.year.toString().slice(6,8);
    }
}
