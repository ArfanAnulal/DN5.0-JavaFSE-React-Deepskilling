import React from 'react';

const IndianPlayers = () => {
  const indianTeam = ['Sachin', 'Dhoni', 'Virat', 'Rohit', 'Yuvraj', 'Raina'];

  // ES6 Array Destructuring
  const [first, second, third, fourth, fifth, sixth] = indianTeam;
  const oddTeam = [first, third, fifth];
  const evenTeam = [second, fourth, sixth];

  // ES6 Spread Operator for Array Merging
  const T20players = ['First Player', 'Second Player', 'Third Player'];
  const RanjiTrophy = ['Fourth Player', 'Fifth Player', 'Sixth Player'];
  const mergedPlayers = [...T20players, ...RanjiTrophy];

  return (
    <div className="indian-players-container">
      <h2>Odd Team Players</h2>
      <ul>
        {oddTeam.map((player, idx) => (
          <li key={idx}>Mr. {player}</li>
        ))}
      </ul>

      <h2>Even Team Players</h2>
      <ul>
        {evenTeam.map((player, idx) => (
          <li key={idx}>Mr. {player}</li>
        ))}
      </ul>

      <h2>Merged Players List (T20 + Ranji)</h2>
      <ul>
        {mergedPlayers.map((player, idx) => (
          <li key={idx}>Mr. {player}</li>
        ))}
      </ul>
    </div>
  );
};

export default IndianPlayers;
