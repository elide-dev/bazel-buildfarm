// Copyright 2020 The Bazel Authors. All rights reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package build.buildfarm.admin;

import build.buildfarm.v1test.GetHostsResult;

public interface Admin {
  void terminateHost(String hostId);

  void stopContainer(String hostId, String containerName);

  GetHostsResult getHosts(String filter, int ageInMinutes, String status);

  void scaleCluster(
      String scaleGroupName,
      Integer minHosts,
      Integer maxHosts,
      Integer targetHosts,
      Integer targetReservedHostsPercent);

  void disableHostScaleInProtection(String instanceName);
}