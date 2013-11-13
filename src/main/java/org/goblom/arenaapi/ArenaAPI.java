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
package org.goblom.arenaapi;

import java.util.HashMap;
import java.util.Map;
import org.bukkit.Location;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

/**
 *
 * @author Goblom
 */
public class ArenaAPI extends JavaPlugin {

    private static ArenaAPI plugin;

    private static Map<String, Arena> arenas = new HashMap();
    private static Map<String, Team> teams = new HashMap();

    private static Map<Arena, BukkitTask> arenaTimers = new HashMap();

    public void onEnable() {
        this.plugin = this;
    }

    public static ArenaAPI getPlugin() {
        return plugin;
    }

    public static Map<Arena, BukkitTask> getArenaTimers() {
        return arenaTimers;
    }

    public static Map<String, Arena> getArenas() {
        return arenas;
    }

    public static Arena getArena(String arenaName) {
        return arenas.get(arenaName);
    }

    public static Arena getArena(Arena arena) {
        return arenas.get(arena.getName());
    }

    public static Arena createArena(String arenaName) {
        return arenas.put(arenaName, new Arena(arenaName));
    }

    public static Arena createArena(String arenaName, int maxPlayers) {
        return arenas.put(arenaName, new Arena(arenaName, maxPlayers));
    }

    public static Arena createArena(String arenaName, int minPlayers, int maxPlayers) {
        return arenas.put(arenaName, new Arena(arenaName, minPlayers, maxPlayers));
    }

    public static Arena createArena(String arenaName, ArenaHandler handler) {
        return arenas.put(arenaName, new Arena(arenaName, handler));
    }

    public static Arena createArena(String arenaName, int minPlayers, int maxPlayers, ArenaHandler handler) {
        return arenas.put(arenaName, new Arena(arenaName, minPlayers, maxPlayers, handler));
    }

    public static Map<String, Team> getTeams() {
        return teams;
    }

    public static Team createTeam(String teamName, Arena arena, Location spawnLocation) {
        return teams.put(teamName, new Team(teamName, arena, spawnLocation));
    }
}
