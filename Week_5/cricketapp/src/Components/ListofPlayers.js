import React from 'react';

const playersList = [
  { name: 'Jack', score: 50 },
  { name: 'Michael', score: 70 },
  { name: 'John', score: 40 },
  { name: 'Ann', score: 61 },
  { name: 'Elisabeth', score: 61 },
  { name: 'Sachin', score: 95 },
  { name: 'Dhoni', score: 100 },
  { name: 'Virat', score: 84 },
  { name: 'Rohit', score: 90 },
  { name: 'Yuvraj', score: 68 },
  { name: 'Raina', score: 55 }
];

const ListofPlayers = () => {
  // ES6 Filter with Arrow Function
  const lowScorers = playersList.filter(player => player.score <= 70);

  return (
    <div className="players-container">
      <h2>List of Players</h2>
      <ul>
        {playersList.map((player, index) => (
          <li key={index}>Mr. {player.name} {player.score}</li>
        ))}
      </ul>

      <h2>List of Players having score less than 70</h2>
      <ul>
        {lowScorers.map((player, index) => (
          <li key={index}>Mr. {player.name} {player.score}</li>
        ))}
      </ul>
    </div>
  );
};

export default ListofPlayers;
