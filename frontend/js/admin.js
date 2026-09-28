const API = "http://localhost:8080/api/players";

async function loadPlayers() {
    const response = await fetch(API);
    const players = await response.json();

    const table = document.getElementById("playersTable");

    table.innerHTML = "";

    players.forEach(player => {
        table.innerHTML += `
            <tr>
                <td>${player.id}</td>
                <td>${player.playerName}</td>
                <td>${player.realName || ""}</td>
                <td>${player.role || ""}</td>
                <td>${player.status || ""}</td>
                <td>
                    <button onclick="deletePlayer(${player.id})">
                        Delete
                    </button>
                </td>
            </tr>
        `;
    });
}

async function addPlayer() {

    const player = {
        playerName: document.getElementById("playerName").value,
        realName: document.getElementById("realName").value,
        role: document.getElementById("role").value,
        image: document.getElementById("image").value,
        socialLink: document.getElementById("socialLink").value,
        status: document.getElementById("status").value
    };

    await fetch(API, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(player)
    });

    alert("Player added successfully!");

    document.querySelectorAll("input").forEach(input => {
        if (input.id !== "status") input.value = "";
    });

    loadPlayers();
}

async function deletePlayer(id) {

    if (!confirm("Delete this player?")) return;

    await fetch(`${API}/${id}`, {
        method: "DELETE"
    });

    loadPlayers();
}

loadPlayers();