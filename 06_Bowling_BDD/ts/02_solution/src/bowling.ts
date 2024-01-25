export class Game {
  rolls: number[] = [];
  currentRoll: number = 0;

  roll(pins: number) {
    this.rolls[this.currentRoll++] = pins;
  }

  score(): number {
    let score = 0;
    let frameIndex = 0;
    for (let frame = 0; frame < 10; frame++) {
      if (this.isStrike(frameIndex)) {
        score += 10 + this.getStrikeBonus(frameIndex);
        frameIndex++;
      } else if (this.isSpare(frameIndex)) {
        score += 10 + this.getSpareBonus(frameIndex);
        frameIndex += 2;
      } else {
        score += this.sumFrame(frameIndex);
        frameIndex += 2;
      }
    }
    return score;
  }

  private isStrike(frameIndex: number): boolean {
    return this.rolls[frameIndex] == 10;
  }
  private getStrikeBonus(frameIndex: number): number {
    return this.rolls[frameIndex + 1] + this.rolls[frameIndex + 2];
  }
  private isSpare(frameIndex: number): boolean {
    return this.rolls[frameIndex] + this.rolls[frameIndex + 1] == 10;
  }
  private getSpareBonus(frameIndex: number): number {
    return this.rolls[frameIndex + 2];
  }
  private sumFrame(frameIndex: number): number {
    return this.rolls[frameIndex] + this.rolls[frameIndex + 1];
  }
}
