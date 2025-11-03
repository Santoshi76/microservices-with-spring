# Enterprise Code Review Standards with Jira Context

## Primary Directive
When reviewing pull requests in this organization, ALWAYS reference the Jira story details posted by github-actions bot.

## Review Framework

### 1. Requirements Validation
- [ ] Verify code implements ALL items in Jira description
- [ ] Confirm each acceptance criterion is met
- [ ] Check for scope creep (unrelated changes)
- [ ] Validate edge cases mentioned in Jira are handled

### 2. Enterprise Standards Compliance

#### Security
- [ ] No hardcoded credentials or secrets
- [ ] Input validation and sanitization
- [ ] Authentication/authorization checks
- [ ] SQL injection prevention
- [ ] XSS prevention
- [ ] CSRF protection where applicable

#### Performance
- [ ] Database queries are optimized (N+1 prevention)
- [ ] Proper indexing considerations
- [ ] Caching strategy where appropriate
- [ ] Resource cleanup (connections, files, etc.)
- [ ] Async operations where beneficial

#### Code Quality
- [ ] SOLID principles followed
- [ ] DRY (Don't Repeat Yourself)
- [ ] Clear naming conventions
- [ ] Adequate error handling
- [ ] Logging for debugging and auditing
- [ ] Comments for complex logic only

#### Testing
- [ ] Unit tests for business logic
- [ ] Integration tests for API endpoints
- [ ] Test coverage > 80% for new code
- [ ] Edge cases covered
- [ ] Negative test cases included

### 3. Documentation Requirements
- [ ] README updated if public API changed
- [ ] API documentation (Swagger/OpenAPI) updated
- [ ] Inline comments for complex algorithms
- [ ] Migration scripts if database changes
- [ ] Changelog entry if customer-facing

### 4. Jira-Specific Review Points

For **Bug Fixes**:
- Does the fix address the root cause?
- Are there regression tests?
- Is the impact scope documented?

For **Features/Stories**:
- Is the feature complete per acceptance criteria?
- Are all user flows covered?
- Is error handling comprehensive?

For **Technical Debt**:
- Is the refactoring safe?
- Are there adequate tests to prevent regression?
- Is the improvement measurable?

## Review Output Format

Structure your review as:
```
## ✅ Requirements Coverage
[Assessment of Jira requirements implementation]

## 🔒 Security Findings
[Any security concerns or ✅ if none]

## ⚡ Performance Considerations
[Performance analysis or ✅ if optimal]

## 🧪 Testing Assessment
[Test coverage and quality evaluation]

## 💡 Suggestions
[Improvement recommendations]

## 🎯 Verdict
- [ ] Approve (meets all criteria)
- [ ] Request Changes (specify required changes)
- [ ] Comment (optional improvements only)
```

## Context Sources
1. **Primary**: Jira story details comment (posted by github-actions bot)
2. **Secondary**: PR description and conversation
3. **Tertiary**: Code changes and file diffs

## Escalation
For PRs that:
- Change critical security boundaries
- Modify core business logic
- Have data migration implications
- Affect > 1000 lines

**Action**: Tag `@tech-lead` or `@security-team` in your review
```

---

### Phase 3: Repository Setup (Week 2)

**1. Branch Protection Rules**
```
Settings → Branches → Add rule

Branch name pattern: main
☑ Require a pull request before merging
☑ Require approvals (2 for enterprise)
☑ Require status checks to pass
☑ Jira Integration / Link Validation
☑ Copilot Review (if using automated)
☑ Require conversation resolution before merging
☑ Do not allow bypassing the above settings