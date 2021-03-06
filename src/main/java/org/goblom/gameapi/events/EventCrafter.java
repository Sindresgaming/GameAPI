/*
 * The MIT License
 *
 * Copyright 2013 Goblom.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package org.goblom.gameapi.events;

import org.goblom.gameapi.events.team.PlayerAddedToTeam;
import org.goblom.gameapi.events.team.PlayerRemovedFromTeam;
import org.goblom.gameapi.events.team.TeamCreated;
import org.goblom.gameapi.events.team.TeamRemoved;
import org.goblom.gameapi.events.arena.ArenaChangePhase;
import org.goblom.gameapi.events.arena.TeamAddedToArena;
import org.goblom.gameapi.events.arena.TeamRemovedFromArena;
import org.goblom.gameapi.events.arena.ArenaCreate;
import org.goblom.gameapi.events.arena.ArenaDelete;
import org.goblom.gameapi.data.Arena;
import org.goblom.gameapi.data.Team;
import org.goblom.gameapi.data.enums.ArenaPhase;

/**
 *
 * @author Goblom
 */
public class EventCrafter {
    
    public static void craftArenaChangePhaseEvent(Arena arena, ArenaPhase changedToPhase, ArenaPhase changedFromPhase) {
        ArenaChangePhase acp = new ArenaChangePhase(arena, changedToPhase, changedFromPhase);
        arena.getHandler().onArenaPhaseChange(acp);
    }
    
    public static void craftArenaDeleteEvent(Arena arena) {
        ArenaDelete ad = new ArenaDelete(arena);
        arena.getHandler().onArenaDelete(ad);
    }
    
    public static void craftArenaCreateEvent(Arena arena) {
        ArenaCreate ac = new ArenaCreate(arena);
        arena.getHandler().onArenaCreate(ac);
    }
    
    public static void craftTeamAddedToArenaEvent(Arena arena, Team team) {
        TeamAddedToArena tata = new TeamAddedToArena(arena, team);
        arena.getHandler().onTeamAddedToArena(tata);
    }
    
    public static void craftTeamRemovedFromArenaEvent(Arena arena, Team team) {
        TeamRemovedFromArena trfa = new TeamRemovedFromArena(arena, team);
        arena.getHandler().onTeamRemovedFromArena(trfa);
    }
    
    public static void craftPlayerAddedToTeamEvent(Team team, String playerName) {
        PlayerAddedToTeam patt = new PlayerAddedToTeam(team, playerName);
        team.getHandler().onPlayerAddedToTeam(patt);
    }
    
    public static void craftPlayerRemovedFromTeamEvent(Team team, String playerName) {
        PlayerRemovedFromTeam prft = new PlayerRemovedFromTeam(team, playerName);
        team.getHandler().onPlayerRemovedFromTeam(prft);
    }
    
    public static void craftTeamCreatedEvent(Team team) {
        TeamCreated tc = new TeamCreated(team);
        team.getHandler().onTeamCreate(tc);
    }
    
    public static void craftTeamRemovedEvent(Team team) {
        TeamRemoved tr = new TeamRemoved(team);
        team.getHandler().onTeamRemove(tr);
    }
}
