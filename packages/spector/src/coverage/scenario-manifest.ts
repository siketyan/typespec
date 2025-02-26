import { loadScenarios } from "../scenarios-resolver.js";
import { Diagnostic } from "../utils/diagnostic-reporter.js";
import { getCommit, getPackageJson } from "../utils/misc-utils.js";
import { ScenarioLocation, ScenarioManifest } from "@typespec/spec-coverage-sdk";
import { getSourceLocation, normalizePath } from "@typespec/compiler";
import { relative } from "path";
import type { Scenario } from "../lib/decorators.js";

export async function computeScenarioManifest(
  scenariosPath: string,
  setName: string
): Promise<[ScenarioManifest | undefined, readonly Diagnostic[]]> {
  const [scenarios, diagnostics] = await loadScenarios(scenariosPath);
  if (diagnostics.length > 0) {
    return [undefined, diagnostics];
  }

  const commit = getCommit(scenariosPath);
  const pkg = await getPackageJson(scenariosPath);
  return [createScenarioManifest(scenariosPath, pkg?.version ?? "?", commit, scenarios, setName), []];
}

export function createScenarioManifest(
  scenariosPath: string,
  version: string,
  commit: string,
  scenarios: Scenario[],
  setName: string
): ScenarioManifest {
  const sortedScenarios = [...scenarios].sort((a, b) => a.name.localeCompare(b.name));
  return {
    version,
    commit,
    scenarios: sortedScenarios.map(({ name, scenarioDoc, target }) => {
      const tspLocation = getSourceLocation(target);
      const location: ScenarioLocation = {
        path: normalizePath(relative(scenariosPath, tspLocation.file.path)),
        start: tspLocation.file.getLineAndCharacterOfPosition(tspLocation.pos),
        end: tspLocation.file.getLineAndCharacterOfPosition(tspLocation.end),
      };
      return { name, scenarioDoc, location };
    }),
    setName
  };
}
